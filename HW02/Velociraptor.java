/**
 * This class defines a velociraptor, which is a subclass of Dinosaur.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Velociraptor extends Dinosaur {
    private int speed;
    private Pack pack;

    /**
     * Constructor that takes in name, height, width, weight, speed, and pack.
     * @param name the name of the velociraptor
     * @param height the height in feet
     * @param width the width in feet
     * @param weight the weight in pounds
     * @param speed the speed in mph
     * @param pack the pack this velociraptor belongs to
     */
    public Velociraptor(String name, double height, double width, double weight, int speed, Pack pack) {
        super(name, height, width, weight);
        if (speed < 0) {
            this.speed = 30;
        } else {
            this.speed = speed;
        }
        this.pack = pack;
    }

    /**
     * Constructor that takes in name and height.
     * @param name the name of the velociraptor
     * @param height the height in feet
     */
    public Velociraptor(String name, double height) {
        this(name, height, 20.0, 1000.0, 30, null);
    }

    /**
     * Copy constructor that deep copies all mutable instance fields.
     * @param v the Velociraptor to copy
     */
    public Velociraptor(Velociraptor v) {
        super(v);
        this.speed = v.speed;
        this.pack = v.pack;
    }

    /**
     * Calculates the enclosure size for a velociraptor.
     * @return enclosure area in square feet
     */
    @Override
    public double enclosureSize() {
        if (this.pack == null) {
            return (this.getWidth() * this.getHeight() * 4);
        } else {
            return (this.getWidth() * this.getHeight() * this.pack.getSize());
        }
    }

    /**
     * Calculates the food needed for a velociraptor.
     * @return food in pounds
     */
    @Override
    public double calculateFood() {
        return (this.getWeight() * this.speed * this.getHeight());
    }

    /**
     * Returns the string representation of this velociraptor.
     * @return formatted string
     */
    @Override
    public String toString() {
        if (this.pack == null) {
            return String.format("%s requires a %.2f square foot enclosure and %.2f pounds of food.",
            this.name, this.enclosureSize(), this.calculateFood());
        } else {
            return String.format("%s is a family of dinosaurs of size %d! %s requires a %.2f"
            + " square foot enclosure and %.2f pounds of food.",
            this.pack.getPackName(), this.pack.getSize(), this.name, this.enclosureSize(), this.calculateFood());
        }
    }
}