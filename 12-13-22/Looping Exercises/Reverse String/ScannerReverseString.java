import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/23/22
 * School: Universidad De Dagupan
 * Description: Reverse String with Scanner for User Input
 * 
 */

public class ScannerReverseString {

    public static void main(String[] args) {
        
        /*
         * Program that takes a String from the user and reverses that String
         * 
         */

        // Creating an instance of the Scanner class to accept input
        Scanner scanOne = new Scanner(System.in);

        // Ask the user for the String that they want to reverse
        System.out.print("Input String: ");
        String userString = scanOne.nextLine();

        // Create a variable that will hold our reversed String
        String reversedUserString = "";

        // Reverse the String using a for loop
        for (int i = userString.length() - 1; i >= 0; i--) { // loop that starts at the end of userString

            reversedUserString += userString.charAt(i); // adds each character in reverse 

        }

        // Display user String and reversed String
        System.out.println("User String: " + userString);
        System.out.println("Reversed String: " + reversedUserString);

        // Close the Scanner
        scanOne.close();

    }
    
}
