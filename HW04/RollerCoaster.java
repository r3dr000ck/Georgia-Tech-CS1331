/**
 * Represents an attraction with a maximum rider capacity.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class RollerCoaster extends Attraction {
    private final int maxCapacity;
    private int occupancy;

    /**
     * Constructs a roller coaster with the provided details.
     *
     * @param name the roller coaster name
     * @param admissionFee the cost of admission
     * @param maxCapacity the maximum number of riders allowed
     */
    public RollerCoaster(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        if (maxCapacity < 25) {
            this.maxCapacity = 25;
        } else {
            this.maxCapacity = maxCapacity;
        }
        this.occupancy = 0;
    }

    /**
     * Constructs a roller coaster with the provided name and default values.
     *
     * @param name the roller coaster name
     */
    public RollerCoaster(String name) {
        this(name, 5.25, 25);
    }

    /**
     * Admits visitors if capacity allows.
     *
     * @param names the visitor names to admit
     */
    @Override
    public void admit(String[] names) {
        if (occupancy + names.length > maxCapacity) {
            System.out.println("RollerCoaster has reached maximum capacity. Please "
                + "visit another time!");
        } else {
            super.admit(names);
            occupancy += names.length;
        }
    }

    /**
     * Records a rating, removes a group, and updates occupancy.
     *
     * @param index the visitor index to remove
     * @param rate the rating to record
     * @return the removed group size, or {@code -1} if the index is invalid
     */
    @Override
    public int rateAndExit(int index, int rate) {
        int removed = super.rateAndExit(index, rate);
        if (removed != -1) {
            occupancy -= removed;
        }
        return removed;
    }

    /**
     * Returns the current occupancy percentage.
     *
     * @return the percent occupancy
     */
    public double percentOccupancy() {
        return Math.round((double) occupancy / maxCapacity * 10000.0) / 100.0;
    }

    /**
     * Returns the formatted roller coaster summary.
     *
     * @return the roller coaster as a string
     */
    @Override
    public String toString() {
        return String.format("RollerCoaster: %s/%.2f%%", super.toString(),
            percentOccupancy());
    }
}
