//********************************************************************
//  RandomEx.java       Author: Stasko
//
//  Demonstrates use of Random class.
//********************************************************************

import java.util.Random;
import java.util.Scanner;

public class RandomEx {

    public static void main(String[] args) {
        int guess, randVal;
        Random gen;
        Scanner scan;

        gen = new Random();
        scan = new Scanner(System.in);
        do {
            System.out.println("Guess a number between 1 and 5");
            guess = scan.nextInt();
            randVal = gen.nextInt(5) + 1;
            if (guess != randVal) {
                System.out.println("Sorry, it was " + randVal);
            }
        } while (guess != randVal);
        System.out.println("Nailed it!");
    }
}
