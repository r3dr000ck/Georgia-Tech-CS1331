public class Driver {
    public static void main(String[] args) {
        int leng = 10;
        Food[] meal1 = TechDining.createMeal(leng);
        Food[] meal2 = TechDining.createMeal(leng);
        System.out.printf("MEAL 1: $%d\n", TechDining.mealCost(meal1));
        System.out.printf("MEAL 2: $%d\n", TechDining.mealCost(meal2));

        Food[][] order1 = TechDining.createOrder(leng);
        Food[][] order2 = TechDining.createOrder(leng);
        System.out.printf("ORDER 1: $%d\n", TechDining.orderCost(order1));
        System.out.printf("ORDER 2: $%d\n", TechDining.orderCost(order2));
    }
}