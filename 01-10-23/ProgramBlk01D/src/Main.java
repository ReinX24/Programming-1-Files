import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer Lab 302
 * Program: For Loop Full Name
 ------------------------------*/

public class Main {

    public static void main(String[] args) {

        /*
         * Create a Java program to accept a full name, then print the name 10 times on
         * the screen. Use a for loop.
         * 
         */

        Scanner scanOne = new Scanner(System.in); // Scanner object to accept user input
        System.out.print("Enter your name?: "); // asking for full name from the user
        String fullName = scanOne.nextLine(); // storing our input in fullName String
        System.out.print("Enter your age?: ");
        int userAge = scanOne.nextInt();
        // int loopCounter = 1; // counter for how many loops we have

        for (int i = 10; i >= 0; i--) { // for loop that loops 10 times
             // Printing counter and fullname
            System.out.println("[" + i + "]: " + " Hello " + fullName + " you are " + userAge + " yrs. old!");
                // if (i % 2 == 0) { System.out.println("Hello World!"); } // incrementing
                if (i % 2 != 0) { System.out.println("Hello World"); } // decrementing
            // loopCounter++; // increments userCounter
        }

        scanOne.close(); // closing our Scanner object after looping

    }

}