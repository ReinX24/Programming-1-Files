import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 16, 2023
 * Place: Home
 * Program: Sum of Positive Numbers, While Loop
 ------------------------------*/

public class SumOfPositiveNumbers {

    public static void main(String[] args) {

        /*
         * Create a program that inputs positive numbers infinitely until the user
         * chooses to input a negative number.
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Sum Of Positive Numbers Calculator]");
        System.out.println("[Negative integers terminates the program]");
        System.out.print("Input positive integer: "); // asks for an integer
        int userNum = scanOne.nextInt(); // stores integer in userNum
        int sumOfNums = 0; // where we will store the sum of all inputted numbers

        while (userNum >= 0) { // while inputted number or userNum is greater than or equal to 0
            sumOfNums += userNum; // adds userNum to sumOfNums, shortcut for sumOfNums = sumOfNums + userNum;
            System.out.println("Current sum:\t" + sumOfNums); // displays current sum of numbers, sumOfNums

            System.out.print("Input positive integer: "); // asks for another positive integer
            userNum = scanOne.nextInt(); // stores new integer in userNum, old value overwritten
        }

        scanOne.close(); // closes our Scanner object when the while loop is broken

    }

}
