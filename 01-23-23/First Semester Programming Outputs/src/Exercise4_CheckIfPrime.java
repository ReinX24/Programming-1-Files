import java.util.Scanner;

public class Exercise4_CheckIfPrime {

    public static void main(String[] args) {

        /*
         * Input a number and check if it is a prime number or not
         * Input: int a
         * Output: "is prime" or "is not prime"
         */

        /* Scanner to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Ask for a number */
        System.out.print("Enter a number: ");
        int a = scanOne.nextInt();
        /* 0 and 1 are not prime numbers */
        if (a == 0 || a == 1) {
            System.out.println(a + " is not prime");
            scanOne.close(); // closing our Scanner object before terminating program
            return; // terminates the program
        }
        /* Check if the number is a prime number */
        boolean isPrime = true; // boolean to tell if a number is prime or not
        for (int i = 2; i <= a / 2; i++) { // a / 2 because a number is not divisible by more than its half
            if (a % i == 0) { // if a is divisible by any number less than half itself, not a prime
                isPrime = false; // sets isPrime to false
            }
        }
        /* Printing results */
        if (isPrime) { // if (isPrime is true), print message in if block
            System.out.println(a + " is prime");
        } else {
            System.out.println(a + " is not prime");
        }
        /* Closing our Scanner object */
        scanOne.close();

    }

}