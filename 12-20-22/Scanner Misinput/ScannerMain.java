import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/13/22
 * School: Universidad De Dagupan
 * Description: Scanner Misinput
 * 
 */

public class ScannerMain {

    public static void main(String[] args) {

        /*
         * When asking for an input from the user, their input may not be the proper
         * data type that you were asking for, this will cause the program to throw and
         * exception. To avoid this, I will somewhat demonstrate how to handle these
         * occurrences WITHOUT using a try catch block to catch these exceptions.
         * 
         */

        // Scanner class to accept input
        Scanner scanOne = new Scanner(System.in);

        // Ask the user for an input
        System.out.print("Enter an integer: ");

        while (!scanOne.hasNextInt()) { // while the user input is not an integer (! means not), run code block below.
            // This loop will infinitely run until the user inputs an integer

            String userInput = scanOne.next(); // stores the misinput in this string
            System.out.println(userInput + " is not an integer.");
            System.out.println("Input must be an integer, try again.");
            System.out.print("Enter an integer: ");

        }

        int numOne = scanOne.nextInt(); // stores integer in numOne if the user does enter an integer

        System.out.println("Number Input: " + numOne); // prints the inputted number

        /*
         * Another way of doing this is the try catch method, though this requires
         * knowledge regarding exception handling, which we have not tackled yet.
         * 
         * Check TryCatch.java file to see demonstration.
         *
         */

        scanOne.close(); // closes the Scanner

    }

}