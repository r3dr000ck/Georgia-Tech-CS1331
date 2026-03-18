/**
 * Represents a vehicle in the transportation network.
 * This class is abstract and is intended to be extended by specific vehicle
 * types such as cars and busses.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;

    /**
     * Constructs a vehicle with the given id, miles, and passengers.
     *
     * @param id the vehicle identifier
     * @param numMiles the miles already travelled
     * @param passengers the passengers currently on board
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        this.earnings = 0.0;
    }

    /**
     * Constructs a vehicle with zero miles travelled.
     *
     * @param id the vehicle identifier
     * @param passengers the passengers currently on board
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Determines whether this vehicle can drive the requested distance.
     *
     * @param d the distance to travel
     * @return true if the vehicle can travel that distance
     */
    public abstract boolean canDrive(int d);

    /**
     * Calculates the cost for this vehicle to travel the requested distance.
     *
     * @param d the distance to travel
     * @return the cost of the ride
     */
    public abstract double calculateCost(int d);

    /**
     * Attempts to add passengers for a ride of the given distance.
     *
     * @param d the distance to travel
     * @param newP the passengers to add
     * @return true if the passengers were added according to the subclass rules
     */
    public abstract boolean addPassengers(int d, String[] newP);

    /**
     * Charges a single ride if this vehicle can travel the given distance.
     *
     * @param d the distance to travel
     */
    public void chargeRide(int d) {
        if (canDrive(d)) {
            this.numMiles += d;
            this.earnings += this.calculateCost(d);
        }
    }

    /**
     * Charges a ride for multiple passengers if this vehicle can travel the
     * given distance.
     *
     * @param d the distance to travel
     * @param numPassengers the number of passengers to charge
     */
    public void chargeRide(int d, int numPassengers) {
        if (canDrive(d)) {
            this.numMiles += d;
            this.earnings += this.calculateCost(d) * numPassengers;
        }
    }

    /**
     * Compares this vehicle to another object.
     * Two vehicles are equal when they have the same id and travelled miles.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal vehicles
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return (this.numMiles == other.numMiles) && (this.id.equals(other.id));
    }

    /**
     * Returns a String representation of this vehicle.
     *
     * @return a formatted description of this vehicle
     */
    @Override
    public String toString() {
        return String.format("%s has travelled %d miles and has earned %.2f dollars.",
            this.id, this.numMiles, this.earnings);
    }
}
