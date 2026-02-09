public class ShoppingMall{
    // Name: Keigo Yoshioka 
    // Fun Fact: Never had a nosebleed before.
    public static void main(String[] args){
        int cash = 100;
        double taxRate = 1.13;
        double subtotal = 58.62;
        String name = "Keigo";
        double change = cash - subtotal * taxRate;
        
        double changeTmp = change * 100.0;
        int change100Int = (int)changeTmp;
        double changeTrunc = change100Int / 100.0;
        System.out.println(name + " has $" + changeTrunc + " dollars remaining!\n" + name + " started with $" + cash + " dollars!");
    }
} 