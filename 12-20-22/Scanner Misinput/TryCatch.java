import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/13/22
 * School: Universidad De Dagupan
 * Description: Try Catch Blocks
 * 
 */

public class TryCatch {

    public static void main(String[] args) {

        // Scanner to accept input
        Scanner scanOne = new Scanner(System.in);

        while (true) { // infinite while loop to keep the program running

            // Variable to store input

            int numOne = 0;

            // Ask the user for an input

            try { // this is a try block

                System.out.print("Enter an integer > 0: ");
                numOne = scanOne.nextInt();

            }

            catch (InputMismatchException ex) { // this is a catch block

                scanOne.nextLine(); // if there is an exception, go to else statement and print error message
                // this will prompt the program to restart itself

            }

            if (numOne > 0) { // checks if numOne is an integer

                System.out.println("User Input: " + numOne);
                scanOne.close(); // closes Scanner
                System.exit(0); // terminates program

            }

            else {

                System.out.println("Input must be a positive integer, try again.");

            }

        }

    }

}
