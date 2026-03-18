/**
 * This class defines a pterodactyl, which is a subclass of Dinosaur.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Pterodactyl extends Dinosaur {
    private double flightCeiling;

    /**
     * Constructor that takes in name, height, width, weight, and flightCeiling.
     * @param name the name of the pterodactyl
     * @param height the height in feet
     * @param width the width in feet
     * @param weight the weight in pounds
     * @param flightCeiling the altitude in feet
     */
    public Pterodactyl(String name, double height, double width, double weight, double flightCeiling) {
        super(name, height, width, weight);
        if (flightCeiling < 10.0 || flightCeiling > 100.0) {
            this.flightCeiling = 50.0;
        } else {
            this.flightCeiling = flightCeiling;
        }
    }

    /**
     * Constructor that takes in name and width.
     * @param name the name of the pterodactyl
     * @param width the width in feet
     */
    public Pterodactyl(String name, double width) {
        this(name, 15.0, width, 1000.0, 50.0);
    }

    /**
     * Constructor that takes in name only.
     * @param name the name of the pterodactyl
     */
    public Pterodactyl(String name) {
        this(name, 12.0);
    }

    /**
     * Copy constructor that deep copies all instance variables.
     * @param p the Pterodactyl to copy
     */
    public Pterodactyl(Pterodactyl p) {
        super(p);
        this.flightCeiling = p.flightCeiling;
    }

    /**
     * Calculates the enclosure size for a pterodactyl.
     * @return enclosure area in square feet
     */
    @Override
    public double enclosureSize() {
        return (4 * (getWidth() * getHeight()) + this.flightCeiling);
    }

    /**
     * Returns the string representation of this pterodactyl.
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format("%s can fly %.2f feet into the air! %s requires a %.2f"
        + " square foot enclosure and %.2f pounds of food.",
        this.name, this.flightCeiling, this.name, this.enclosureSize(), this.calculateFood());
    }
}