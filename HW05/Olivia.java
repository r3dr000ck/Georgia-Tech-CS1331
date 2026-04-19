import java.util.ArrayList;

/**
 * Represents Olivia's static rental state and behaviors.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart = new ArrayList<Media>();
    private static boolean canUseConsole;

    /**
     * Attempts to add a media item from the store to Olivia's cart.
     *
     * @param m the media item Olivia wants
     * @param store the store Olivia is shopping at
     * @return true if the item was added to the cart, false otherwise
     */
    public static boolean addToCart(Media m, Blockbuster store) {
        Media found = store.findMedia(m);
        if (found == null || found.getRentalPrice() > budget) {
            return false;
        }
        if (found instanceof VideoGame
            && ((VideoGame) found).getNeedsConsole() && !canUseConsole) {
            return false;
        }

        Media removed = store.removeMedia(found);
        cart.add(removed);
        budget -= removed.getRentalPrice();
        return true;
    }

    /**
     * Removes the first matching media item from Olivia's cart and returns it
     * to the store.
     *
     * @param m the media item Olivia no longer wants
     * @param store the store Olivia is shopping at
     */
    public static void changeMind(Media m, Blockbuster store) {
        for (int i = 0; i < cart.size(); i++) {
            Media current = cart.get(i);
            if (current.equals(m)) {
                cart.remove(i);
                store.addMedia(current);
                budget += current.getRentalPrice();
                break;
            }
        }
    }
}
