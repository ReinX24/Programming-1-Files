import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/3/22
 * School: Universidad De Dagupan
 * Description: Basic Calculator 
 * 
 */

public class BasicCalculator {

    public static void main(String[] args) {

        // We will now create a Basic Calculator using the Scanner class and Branching
        // Statements

        // Create a Scanner
        Scanner scanOne = new Scanner(System.in);

        // Variables to hold user input
        int inputOne = 0;
        int inputTwo = 0;
        char myOperator;
        int myResult = 0;

        // Ask the user for inputs
        System.out.print("Enter 1st number: ");
        inputOne = scanOne.nextInt();

        System.out.print("Enter 2nd number: ");
        inputTwo = scanOne.nextInt();

        System.out.print("Enter operator(+,-,x,/): ");
        myOperator = scanOne.next().charAt(0); // how to put user input in myOperator

        // We will now use the Switch case syntax for our calculator
        // We will use the Switch case rather than the If - else if - nested if syntax
        // so that we could demonstrate how the Switch case works

        switch (myOperator) {

            case '+': // checks if myOperator is a + sign, will run code below if is is a + sign
                myResult = inputOne + inputTwo;
                System.out.println("Sum of the two numbers: " + myResult);
                break;

            case '-': // checks if myOperator is a - sign
                myResult = inputOne - inputTwo;
                System.out.println("Difference of the two numbers: " + myResult);
                break;

            case 'x': // checks if myOperator is a x sign
                myResult = inputOne * inputTwo;
                System.out.println("Product of the two numbers: " + myResult);
                break;

            case '/': // checks if myOperator is a / sign
                myResult = inputOne / inputTwo;
                System.out.println("Quotient of the two numbers: " + myResult);
                // Note: Dividing integers may cause problems, ex. 3 / 6 will result in zero
                // instead of 0.5
                // This is because integers rounds towards 0, it would be much better to use
                // float instead
                // of int in this case but for demonstration purposes, we will use int for now
                break;

            default: // will run this if all cases return false
                System.out.println("[Not a valid operator]");
                break;

        }

        scanOne.close(); // closes the Scanner

    }

}
