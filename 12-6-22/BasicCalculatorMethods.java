import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/3/22
 * School: Universidad De Dagupan
 * Description: Basic Calculator with Methods and Loops 
 * 
 */

class BasicCalculatorMethods {

    // Variables to hold user input
    static float inputOne = 0;
    static float inputTwo = 0;
    static char myOperator = ' ';
    static float myResult = 0;
    static boolean appOn = true;
    static int userChoice = 0;

    // Create a Scanner
    static Scanner scanOne = new Scanner(System.in);

    public static void main(String[] args) {

        // We will now create a Basic Calculator using the Scanner class and Branching
        // Statements
        
        // NOTE: This is an advanced version of this exercise, the code inside this file
        // makes use of static methods, static variables, loops, exception handling,
        // and more. 

        while (appOn) {

            mainMenu(); // loops mainMenu until loop is broken

        }


    }

    public static void mainMenu() {

        System.out.println("=========================");
        System.out.println("[  2 Number Calculator  ]");
        System.out.println("[1] Calculator");
        System.out.println("[2] Close Application");
        System.out.println("=========================");

        try {

        resetNum(); // resets inputOne, inputTwo, myOperator, myResult
        System.out.print("Input: "); // asks for user input
        userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to default statement

        }

        switch (userChoice) {

            case 1:
                userChoice = 0; // resets userChoice to zero
                calcMenu(); // goes to calcMenu method
                break;

            case 2:
                closeApp(); // closes the application
                break;

            default:
                System.out.println("[Invalid Input, Try Again]"); // prints when default occurs
                mainMenu(); // returns to mainMenu

        }
        

    }

    public static void calcMenu() {

        try {

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

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to default statement when an exception occurs

        }

        switch (myOperator) {

            case '+': // checks if myOperator is a + sign, will run code below if is is a + sign
                addNum();
                break;

            case '-': // checks if myOperator is a - sign
                minNum();
                break;

            case 'x': // checks if myOperator is a x sign
                mulNum();
                break;

            case '/': // checks if myOperator is a / sign
                divNum();
                break;

            default: // will run this if all cases return false
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(); // returns the user to mainMenu 
                break;

        }

    }

    public static void addNum() { // no parameters needed since the variables are static

        myResult = inputOne + inputTwo;
        System.out.println("[Sum of the two numbers: " + myResult + "]");

    }

    public static void minNum() {

        myResult = inputOne - inputTwo;
        System.out.println("[Difference of the two numbers: " + myResult + "]");

    }

    public static void mulNum() {

        myResult = inputOne * inputTwo;
        System.out.println("[Product of the two numbers: " + myResult + "]");

    }

    public static void divNum() {

        myResult = inputOne / inputTwo;
                System.out.println("[Quotient of the two numbers: " + myResult + "]");
                // Note: Dividing integers may cause problems, ex. 3 / 6 will result in zero
                // instead of 0.5
                // This is because integers rounds towards 0, it would be much better to use
                // float instead
                // of int in this case but for demonstration purposes, we will use int for now

    }

    public static void closeApp() {

        scanOne.close(); // closes Scanner
        appOn = false; // breaks appOn while loop

    }

    public static void resetNum() {

        inputOne = 0;
        inputTwo = 0;
        myOperator = ' ';
        myResult = 0;

    }

}