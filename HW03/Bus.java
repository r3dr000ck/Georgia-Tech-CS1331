/**
 * Represents a bus in the transportation network.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * Constructs a bus with the given state values.
     *
     * @param id the bus identifier
     * @param numMiles the miles already traveled
     * @param location the area where this bus operates
     * @param stopsPerMile the number of stops this bus makes per mile
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * Constructs a bus with default mileage and stops per mile.
     *
     * @param id the bus identifier
     * @param location the area where this bus operates
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }

    /**
     * Determines whether this bus can travel the given distance.
     *
     * @param d the distance to travel
     * @return true if the distance is nonnegative
     */
    @Override
    public boolean canDrive(int d) {
        return (d >= 0);
    }

    /**
     * Calculates the per-passenger cost for this bus to travel the given distance.
     *
     * @param d the distance to travel
     * @return the per-passenger ride cost, or -1.0 if the bus cannot travel
     */
    @Override
    public double calculateCost(int d) {
        if (!canDrive(d)) {
            return -1.0;
        }
        return (d * 3.0 / stopsPerMile);
    }

    /**
     * Attempts to add passengers for a ride of the given distance.
     *
     * @param d the distance to travel
     * @param newP the passengers to add
     * @return true if the bus can travel the given distance, and false otherwise
     */
    @Override
    public boolean addPassengers(int d, String[] newP) {
        if (!canDrive(d)) {
            return false;
        }

        int nextId = 0;
        int boarded = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                this.passengers[i] = newP[nextId];
                nextId++;
                boarded++;
            }
            if (nextId == newP.length) {
                break;
            }
        }

        if (boarded > 0) {
            chargeRide(d, boarded);
        }
        return true;
    }

    /**
     * Compares this bus to another object.
     * Two busses are equal when they have equal id, miles, location, and stops per mile.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal busses
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Bus other = (Bus) obj;
        return this.stopsPerMile == other.stopsPerMile
            && this.location.equals(other.location);
    }

    /**
     * Returns a String representation of this bus.
     *
     * @return a formatted description of this bus
     */
    @Override
    public String toString() {
        return String.format(
            "Bus %s This bus drives around %s and makes %d stops per mile.",
            super.toString(), this.location, this.stopsPerMile);
    }
}
