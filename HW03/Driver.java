/**
 * Driver class used to exercise the vehicle hierarchy.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class Driver {

    /**
     * Runs simple tests for Car and Bus objects.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Car carOne = new Car("C001");
        Car carTwo = new Car("C001");

        carOne.addPassengers(12, new String[]{"Alex", "Blair"});

        System.out.println(carOne.toString());
        System.out.println(carTwo.toString());
        System.out.println(carOne.equals(carTwo));

        Bus busOne = new Bus("B001", "Midtown");
        Bus busTwo = new Bus("B001", "Downtown");

        busOne.addPassengers(5, new String[]{"Chris", "Drew", "Evan"});

        System.out.println(busOne.toString());
        System.out.println(busTwo.toString());
        System.out.println(busOne.equals(busTwo));
    }
}
