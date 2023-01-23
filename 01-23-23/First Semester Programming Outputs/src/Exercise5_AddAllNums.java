import java.util.Scanner;

public class Exercise5_AddAllNums {

    public static void main(String[] args) {

        /*
         * Create a program that will ask for a number and add all numbers below that
         * will be added together. Print the sum of all the numbers.
         * Input: int n
         * Output: Sum of all numbers below int n including n (Starting from 0)
         */

        /* Scanner object to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Ask for n from user */
        System.out.print("Enter a number: ");
        int n = scanOne.nextInt();
        /* Loop from 0 to n and add all of the numbers */
        int sumOfN = 0; // where we will store our sum of numbers
        for (int i = 1; i <= n; i++) { // loops from 0 to n
            sumOfN += i; // adds each iteration of i to sumOfN
        }
        /* Printing results */
        System.out.println("Sum of 1 to " + n + " : " + sumOfN);
        /* Closing our Scanner object */
        scanOne.close();

    }

}
