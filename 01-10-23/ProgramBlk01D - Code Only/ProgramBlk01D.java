import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer lab 302
 * Program: For Loop Full Name
 ------------------------------*/

public class ProgramBlk01D {

    public static void main(String[] args) {

        /*
         * Create a Java program to accept a fullname, then print the name 10 times on
         * the screen. Use a for loop.
         * 
         */

        Scanner scanOne = new Scanner(System.in); // scanner object to accept user input
        System.out.print("Input full name: "); // asking for full name from the user
        String fullName = scanOne.nextLine();
        int userCounter = 1; // counter for how many loops we have

        for (int i = 0; i < 10; i++) {
            System.out.println(userCounter + " : " + fullName); // printing current counter and fullname 
            userCounter++; // increments userCounter
        }

        scanOne.close(); // closing our Scanner object

    }

}