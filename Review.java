public class Review {
    public static void review1() {
        // Given the if/else block,
        // rewrite using the ternary operator
        int a = 1331;
        int b = 1332;
        int result;
        if (a < b) {
            result = b - a;
        } else {
            result = a - b;
        }
        System.out.println(result);
    }

    public static void review2() {
        // What is the output of the following code?
        int a = 41;
        int b = 42;
        if (b > a)
            if (b < 41)
                System.out.println("foo");
        else
            System.out.println("bar");
    }

    public static void review3() {
        // Does the code below print "Hallo" to the console?
        String s = "Hello";
        replaceXwithY(s, 'e', 'a');
        System.out.println(s);
    }
    public static void replaceXwithY(String s, char x, char y) {
        s = s.replace(x, y);
    }

    public static void review4() {
        // 1. Create an enum called ClassYear with the values of
        // FRESHMAN, SOPHOMORE, JUNIOR, SENIOR

        // 2. Declare a variable "year" and assign to it 
        // the enum value of FRESHMAN

        // 3. Print out the name of the enum value and
        // its ordinal value
    }

    public static void review5(String[] args) {
        // 1. Implement a function that prints out
        // each command-line argument on a separate line
        // 2. What needs to be entered on the command line
        // to produce this output?
        //I
        //Am
        //Groot
    }

    public static void review6() {
        // convert this do while loop to an equivalent for-loop
        int k = 5;
        do {
            k *= 2;
            System.out.println(k);
            k -= 4;
        } while (k < 50);
    }

    public static void review7() {
        // What is the output of the code below?
        String x = new String("Phoenix");
        String y = new String("Phoenix");
        String z = "Phoenix";
        System.out.println(x == y);
        System.out.println(z == y);
    }

    public static void review8() {
        // Print each character in a given string 
        // on a separate line
        String s = "Hello, World!";
    }

    public static void review9() {
        // Generate a random integer within [100, 200]
    }

    public static void main(String[] args) {
        review1();
        review2();
        review3();
        review4();
        review5(args);
        review6();
        review7();
        review8();
        review9();
    }
}