import java.util.Random;

/**
 * Demonstrates basic functionality of the java.util.Random class
 */
public class RandomBasics {

    public static void main(String[] args) {
        Random random = new Random();

        
        int i = random.nextInt(); //random integers -> + & -
        System.out.println("i == " + i);
        
        i = random.nextInt(50); // set upper bound 0 to 50-1 (i.e. 50, exclusive)
        System.out.println("i == " + i);

        float f = random.nextFloat();
        System.out.println("f == " + f);

        System.out.println(random.nextBoolean());
        System.out.println(random.nextDouble());
        System.out.println(random.nextLong());
    }
}
