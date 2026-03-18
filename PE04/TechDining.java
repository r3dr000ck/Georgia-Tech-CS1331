import java.util.Random;

public class TechDining {
    public static Food[] createMeal(int leng) {
        Random rand = new Random();
        Food[] ret = new Food[leng];
        for (int i = 0; i < leng; i++) {
            int ind = rand.nextInt(6);
            ret[i] = Food.values()[ind];
        }
        return ret;
    }

    public static Food[][] createOrder(int leng) {
        int cnt = 0;
        Food[][] ret = new Food[leng][];
        for (int i = leng; i > 0; i--) {
            ret[cnt] = createMeal(i);
            cnt++;
        }
        return ret;
    }

    public static int mealCost(Food[] arr) {
        int ret = 0;
        for (Food i : arr) {
            ret += i.ordinal();
        }
        return ret;
    }

    public static int orderCost(Food[][] arr) {
        int ret = 0;
        for (Food[] i : arr) {
            ret += mealCost(i);
        }
        return ret;
    }
}