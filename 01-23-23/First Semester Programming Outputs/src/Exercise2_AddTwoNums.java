import java.util.Scanner;

public class Exercise2_AddTwoNums {

    public static void main(String[] args) {

        /*
         * Input 2 numbers and print sum of 2 numbers
         * Input: int a, int b
         * Output: (a + b)
         */

        /* Scanner object to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Asking for first number (a) */
        System.out.print("Enter first number: ");
        int a = scanOne.nextInt();
        /* Asking for second number (b) */
        System.out.print("Enter second number: ");
        int b = scanOne.nextInt();
        /* Printing sum of the two numbers (a + b) */
        System.out.println("The sum of " + a + " and " + b + " is " + (a + b));
        /* Closing our Scanner object */
        scanOne.close();

    }

}
