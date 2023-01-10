import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer Lab 302
 * Program: For Loop Full Name & Print Message After Each Even Number
 ------------------------------*/

public class PrintAfterEvenNum {

    public static void main(String[] args) {

        /*
         * Similar to Printing Full Name Program but in this version, print the message
         * "Hello World" after every 2 messages with full name being printed. Print
         * after 2, 4, 6, 8, 10. This program also assumes that your for loop will start
         * at index 0 rather than any other number.
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.print("Enter your name?: ");
        String fullName = scanOne.nextLine();
        System.out.print("Enter your age?: ");
        int userAge = scanOne.nextInt();
        int loopCounter = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("[" + loopCounter + "]: Hello " + fullName + " you are " + userAge + " yrs. old!");
            if (loopCounter % 2 == 0) {
                System.out.println("Hello World");
            }
            loopCounter++;
        }

        scanOne.close();

    }

}
