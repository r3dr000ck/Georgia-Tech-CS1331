/**
 * Demonstrates attraction and roller coaster behavior.
 *
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class TripGuide {
    /**
     * Runs a sample amusement park simulation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Attraction[] attractions = {
            new Attraction("Ferris Wheel", 7.50),
            new Attraction("Haunted House", 7.50),
            new RollerCoaster("Thunder Run", 7.50, 30),
            new Attraction("Mirror Maze", 4.25),
            new RollerCoaster("Sky Scream", 9.00, 25),
            new Attraction("Tea Cups", 3.75),
            new RollerCoaster("Canyon Drop", 6.50, 40)
        };

        String[] groupOne = {"Alex", "Blair", "Chris", "Drew"};
        String[] groupTwo = {"Evan", "Frankie", "Gray", "Harper", "Indy"};
        String[] groupThree = {"Jules", "Kai", "Lane", "Morgan", "Nico",
            "Oakley", "Parker", "Quinn", "Reese", "Sawyer", "Tatum", "Vale"};
        String[] oversizedGroup = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};

        for (Attraction attraction : attractions) {
            attraction.admit(groupOne);
            attraction.printVisitors();
            attraction.admit(groupTwo);
            attraction.printVisitors();
            attraction.admit(groupThree);
            attraction.printVisitors();
        }

        attractions[2].admit(oversizedGroup);
        attractions[2].printVisitors();
        attractions[4].admit(oversizedGroup);
        attractions[4].printVisitors();

        attractions[0].rateAndExit(0, 8);
        attractions[1].rateAndExit(0, 8);
        attractions[2].rateAndExit(1, 10);
        attractions[3].rateAndExit(0, 3);
        attractions[5].rateAndExit(-1, 12);

        for (Attraction attraction : attractions) {
            System.out.println(attraction);
            attraction.printVisitors();
        }

        System.out.println(attractions[0].compareTo(attractions[1]));
        System.out.println(attractions[2].compareTo(attractions[3]));
        System.out.println(attractions[0].compareTo(attractions[2]));
        System.out.println(attractions[5].compareTo(attractions[6]));
    }
}
