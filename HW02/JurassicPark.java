/**
 * Test driver for the Jurassic World Rancher system.
 * @author Keigo Yoshioka
 * @version 1.0
 */
public class JurassicPark {
    /**
     * Main method to test all classes.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Pack raptorPack = new Pack(5, "Alpha Squad");
        Pack defaultPack = new Pack(-1, "");

        Dinosaur dino1 = new Dinosaur("Tiny", 5.0, 5.0, 100.0);
        Dinosaur dino2 = new Dinosaur(dino1);

        Pterodactyl ptero1 = new Pterodactyl("Ptera-A", 10.0, 15.0, 800.0, 80.0);
        Pterodactyl ptero2 = new Pterodactyl(ptero1);

        Velociraptor velo1 = new Velociraptor("Blue", 6.0, 10.0, 500.0, 50, raptorPack);
        Velociraptor velo2 = new Velociraptor(velo1);

        System.out.println("=== Enclosure Building ===");
        System.out.println(dino1.buildEnclosure());
        System.out.println(dino2.buildEnclosure());
        System.out.println(ptero1.buildEnclosure());
        System.out.println(ptero2.buildEnclosure());
        System.out.println(velo1.buildEnclosure());
        System.out.println(velo2.buildEnclosure());

        System.out.println("\n=== Velociraptor toString ===");
        System.out.println(velo1.toString());
        System.out.println(velo2.toString());

        Velociraptor loneVelo = new Velociraptor("Solo", 5.0);
        System.out.println(loneVelo.toString());

        System.out.println("\n=== Pack Info ===");
        System.out.println(raptorPack.toString());
        System.out.println(defaultPack.toString());

        System.out.println("\nTotal Enclosures: " + Dinosaur.getTotalEnclosures());
    }
}