import java.util.Scanner;

public class Exercise6_FibonacciNumberIndex {

    public static void main(String[] args) {

        /*
         * Compute for the n-th Fibonacci number Fn
         * Input: int n
         * Output: int Fn
         * 
         * Example:
         * 0, 1, 1, 2, 3, 5
         * 
         * int n = 5
         * We will then compute for the 5th fibonacci number
         * Output: 5 (5th index)
         * 
         * int n = 4
         * Output: 3(4th index)
         * 
         * More resources:
         * https://www.inchcalculator.com/fibonacci-sequence-calculator/
         */

        /* Scanner object to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Ask the user which index in the fibonacci sequence would they like to find */
        System.out.print("Enter n-th index for Fibonacci sequence: ");
        int n = scanOne.nextInt();
        /* Calculate for n-th Fibonacci number using Binet Formula */
        int fibonacciNumber = (int) ((Math.pow((1 + Math.sqrt(5)) / 2, n) - (Math.pow((1 - Math.sqrt(5)) / 2, n)))
                / Math.sqrt(5));
        /* Printing result */
        System.out.println("The index of " + n + " in the Fibonacci squence is: " + fibonacciNumber);
        /* Closing our Scanner object */
        scanOne.close();

    }

}
