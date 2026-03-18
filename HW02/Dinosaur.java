/**
 * This class defines a dinosaur.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Dinosaur {
    /** The name of this dinosaur. */
    protected final String name;
    private double height;
    private double width;
    private double weight;
    /** The total number of dinosaurs that have an enclosure at the park. */
    protected static int totalEnclosures = 0;

    /**
     * Constructor that takes in name, height, width, and weight.
     * @param name the name of the dinosaur
     * @param height the height in feet
     * @param width the width in feet
     * @param weight the weight in pounds
     */
    public Dinosaur(String name, double height, double width, double weight) {
        if (name == null || name.trim().length() < 1) {
            this.name = "Barney";
        } else {
            this.name = name;
        }

        this.height = height;
        this.width = width;
        this.weight = weight;
    }

    /**
     * No-arg constructor with default values.
     */
    public Dinosaur() {
        this("Barney", 15.0, 20.0, 1000.0);
    }

    /**
     * Copy constructor that deep copies all necessary instance fields.
     * @param d the Dinosaur to copy
     */
    public Dinosaur(Dinosaur d) {
        this(
            (d == null) ? "Barney" : d.name,
            (d == null) ? 15.0 : d.height,
            (d == null) ? 20.0 : d.width,
            (d == null) ? 1000.0 : d.weight
        );
    }

    /**
     * Returns the enclosure size for this dinosaur.
     * @return the enclosure area in square feet
     */
    public double enclosureSize() {
        return (10.0 * this.width * this.height);
    }

    /**
     * Returns the amount of food needed for this dinosaur.
     * @return food in pounds
     */
    public double calculateFood() {
        return (this.weight * this.width * this.height);
    }

    /**
     * Returns the string representation of this dinosaur.
     * @return formatted string
     */
    public String toString() {
        return String.format("%s requires a %.2f square foot enclosure and %.2f pounds of food.",
        this.name, this.enclosureSize(), this.calculateFood());
    }

    /**
     * Attempts to build an enclosure for this dinosaur.
     * @return a string describing the result
     */
    public String buildEnclosure() {
        double enc = this.enclosureSize();
        double food = this.calculateFood();

        if (enc > 6000.0 || food > 80000.0) {
            return this.toString() + String.format(" %s is too expensive for the park!", this.name);
        } else {
            this.totalEnclosures += 1;
            return this.toString() + String.format(" %s has been added to the park!", this.name);
        }
    }

    /**
     * Gets the height of this dinosaur.
     * @return height in feet
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets the width of this dinosaur.
     * @return width in feet
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the weight of this dinosaur.
     * @return weight in pounds
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Gets the total number of enclosures built.
     * @return totalEnclosures
     */
    public static int getTotalEnclosures() {
        return totalEnclosures;
    }
}