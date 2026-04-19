import java.util.ArrayList;

/**
 * Represents a Blockbuster store inventory.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * Constructs an empty Blockbuster inventory.
     */
    public Blockbuster() {
        this.inventory = new ArrayList<Media>();
    }

    /**
     * Adds a media item to the end of the inventory.
     *
     * @param m the media item to add
     */
    public void addMedia(Media m) {
        this.inventory.add(m);
    }

    /**
     * Removes the first matching media item from the inventory.
     *
     * @param m the media item to remove
     * @return the removed media item, or null if it was not found
     */
    public Media removeMedia(Media m) {
        Media ret = null;
        for (int i = 0; i < this.inventory.size(); i++) {
            Media med = this.inventory.get(i);
            if (med.equals(m)) {
                ret = med;
                this.inventory.remove(i);
                break;
            }
        }
        return ret;
    }

    /**
     * Sorts the inventory in ascending order using bubble sort.
     */
    public void sortMedia() {
        for (int i = 0; i < this.inventory.size(); i++) {
            for (int j = 0; j < this.inventory.size() - 1; j++) {
                Media a = this.inventory.get(j);
                Media b = this.inventory.get(j + 1);
                if (a.compareTo(b) > 0) {
                    this.inventory.set(j, b);
                    this.inventory.set(j + 1, a);
                }
            }
        }
    }

    /**
     * Finds a media item in the sorted inventory using binary search.
     *
     * @param m the media item to search for
     * @return the matching media item from the store, or null if not found
     */
    public Media findMedia(Media m) {
        int left = 0;
        int right = this.inventory.size() - 1;

        while (right >= left) {
            int mid = (left + right) / 2;
            Media cur = this.inventory.get(mid);
            if (cur.compareTo(m) == 0) {
                return cur;
            } else if (cur.compareTo(m) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    /**
     * Returns the most popular movie in the inventory.
     *
     * @return the highest-rated movie, or null if there are no movies
     */
    public Movie getMostPopularMovie() {
        Movie ret = null;

        for (Media m : this.inventory) {
            if (!(m instanceof Movie)) {
                continue;
            }
            Movie movie = (Movie) m;
            if (ret == null || movie.getRating() > ret.getRating()) {
                ret = movie;
            } else if (movie.getRating() == ret.getRating()
                && movie.getName().compareTo(ret.getName()) < 0) {
                ret = movie;
            }
        }
        return ret;
    }
}
