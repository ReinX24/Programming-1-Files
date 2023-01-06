import java.util.Scanner;

public class EvenOddInput {

    public static void main(String[] args) {

        /*
         * Write a program that reads a set of integers, and then prints the sum of the
         * even and odd integers.
         * 
         */

        // NOTE: Program uses do while loop Instead of for loop, disregard if unfamiliar
        Scanner scanOne = new Scanner(System.in);

        int userNum = 0;
        char userChoice;
        int evenSum = 0;
        int oddSum = 0;

        System.out.println("[Odd / Even Number Sum Calculator]");

        do { // runs once before prompting user to continue

            System.out.print("Input a number: ");
            userNum = scanOne.nextInt();

            if (userNum % 2 == 0) {
                evenSum += userNum;
            } else {
                oddSum += userNum;
            }

            System.out.print("Continue adding numbers? (y/n): "); // loops if the user chooses y
            userChoice = scanOne.next().charAt(0);

        } while (userChoice == 'y' || userChoice == 'Y');

        System.out.println("Sum of odd numbers: " + oddSum);
        System.out.println("Sum of even numbers: " + evenSum);

    }

}
