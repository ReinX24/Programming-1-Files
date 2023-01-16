import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 16, 2023
 * Place: Home
 * Program: Print Multiplication Table of User Input using Do - While Loop
 ------------------------------*/

public class MultiplicationTable {

    public static void main(String[] args) {

        /*
         * Create a program that will print the multiples of a number with its
         * multiplicand ranging from 1 to 10.
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Multiplication Table Program]");
        System.out.print("Input number: "); // asks the user for a number
        int userNum = scanOne.nextInt(); // stores number in userNum

        int multiplicandNum = 1; // serves as our multiplicand
        do {
            System.out.println("\t" + userNum + "\t*\t" + multiplicandNum + "\t=\t" + userNum * multiplicandNum);
            // prints userNum, multiplicandNum, and product. \t is an escape character for
            // tab
            multiplicandNum++; // increments multiplicand
        } while (multiplicandNum <= 10); // run do loop while multiplicandNum is less than or equal to 10

        scanOne.close(); // closes our Scanner object

    }

}
