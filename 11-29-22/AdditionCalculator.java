import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/3/22
 * School: Universidad De Dagupan
 * Description: Basic Addition Calculator
 * 
 */

public class AdditionCalculator {

    public static void main(String[] args) {

        // Adding 2 numbers using the Scanner class

        // Create a Scanner instance
        Scanner scanOne = new Scanner(System.in);

        // Create variables that will hold our inputs
        int numOne = 0;
        int numTwo = 0;
        int mySum = 0;

        // Ask user for the numbers
        System.out.print("Enter 1st number: ");
        numOne = scanOne.nextInt();

        System.out.print("Enter 2nd number: ");
        numTwo = scanOne.nextInt();

        // Now we will add numOne and numTwo together and store them in mySum
        mySum = numOne + numTwo;

        // Display the sum of the two numbers
        System.out.println("Sum of the two numbers: " + mySum);

        scanOne.close(); // closes the scanner

    }

}
