import java.util.Scanner;
import java.util.Random;

public class PokemonBattle{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String my_poke;
        String ri_poke;

        double ri_health = (double)(rand.nextInt(20) + 40);

        System.out.print("Enter your Pokemon's nickname: ");
        my_poke = scan.nextLine().trim();

        System.out.print("Enter your rival's Pokemon's nickname: ");
        ri_poke = scan.nextLine().trim();

        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n", ri_poke, ri_health);

        int rounds = 0;

        do{
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            double total_dam = 0.0;
            if(attack == AttackType.SCRATCH){
                int num = rand.nextInt(3) + 1;
                double dam = (rand.nextDouble() * 5 + 1.0);
                total_dam = num * dam;
                ri_health -= total_dam;
            }
            else if(attack == AttackType.SURF){
                total_dam = (rand.nextDouble() * 9 + 2.0);
                ri_health -= total_dam;
            }
            else if(attack == AttackType.TACKLE){
                total_dam = (rand.nextDouble() * 2 + 7.0);
                ri_health -= total_dam;
            }

            rounds += 1;

            System.out.printf("%s used %s and did %.2f damage. Your rival’s %s has %.2f health remaining.\n", my_poke, attack, total_dam, ri_poke, Math.max(0, ri_health));
        } while(ri_health > 0.0);
        
        System.out.printf("%s fainted after %d turns!\n", ri_poke, rounds);

        double prize = rand.nextDouble() * (-1200) + 2400;

        System.out.printf("You have earned $%.2f!\n", prize);

        scan.close();
        
    }
}