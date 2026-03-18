/**
 * Represents a car in the transportation network.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;

    /**
     * Constructs a car with the given state values.
     *
     * @param id the car identifier
     * @param numMiles the miles already travelled
     * @param passengers the passengers currently in the car
     * @param rate the cost per mile
     * @param fees the one-time ride fee
     * @param maxNumMiles the maximum miles this car can travel
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }

    /**
     * Constructs a car with default passenger capacity and pricing.
     *
     * @param id the car identifier
     * @param numMiles the miles already travelled
     * @param maxNumMiles the maximum miles this car can travel
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        this(id, numMiles, new String[4], 10.0, 15.0, maxNumMiles);
    }

    /**
     * Constructs a car with default mileage, passenger capacity, and pricing.
     *
     * @param id the car identifier
     */
    public Car(String id) {
        this(id, 0, 200);
    }

    /**
     * Determines whether this car can travel the given distance.
     *
     * @param d the distance to travel
     * @return true if the distance is nonnegative and within the car's remaining miles
     */
    @Override
    public boolean canDrive(int d) {
        return (d >= 0 && numMiles + d <= maxNumMiles);
    }

    /**
     * Calculates the cost for this car to travel the given distance.
     *
     * @param d the distance to travel
     * @return the ride cost, or -1.0 if the car cannot travel that distance
     */
    @Override
    public double calculateCost(int d) {
        if (!canDrive(d)) {
            return -1.0;
        }
        return (d * rate) + fees;
    }

    /**
     * Attempts to add all new passengers for a ride of the given distance.
     *
     * @param d the distance to travel
     * @param newP the passengers to add
     * @return true if every passenger fits and the car can travel the distance
     */
    @Override
    public boolean addPassengers(int d, String[] newP) {
        int cnt = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (passengers[i] == null) {
                cnt++;
            }
        }
        if (!canDrive(d) || cnt < newP.length) {
            return false;
        }

        int nextId = 0;
        for (int i = 0; i < this.passengers.length; i++) {
            if (this.passengers[i] == null) {
                this.passengers[i] = newP[nextId];
                nextId++;
                if (nextId == newP.length) {
                    break;
                }
            }
        }

        chargeRide(d);
        return true;
    }

    /**
     * Compares this car to another object.
     * Two cars are equal when they have equal id, miles, rate, fees, and maximum miles.
     *
     * @param obj the object to compare against
     * @return true if the objects are equal cars
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Car other = (Car) obj;
        return Double.compare(this.rate, other.rate) == 0
            && Double.compare(this.fees, other.fees) == 0
            && this.maxNumMiles == other.maxNumMiles;
    }

    /**
     * Returns a String representation of this car.
     *
     * @return a formatted description of this car
     */
    @Override
    public String toString() {
        return String.format(
            "Car %s It can only drive %d miles. It costs %.2f dollars per mile and there is a"
            + " one-time fee of %.2f dollars.", super.toString(), this.maxNumMiles, this.rate, this.fees);
    }
}
