import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/6/22
 * School: Universidad De Dagupan
 * Description: Basic Calculator with Methods, Loops, and Exception Handling
 * 
 */

class BasicCalculatorMethods {

    // NOTE: This is an advanced version of the Basic Java Calculator exercise, the
    // code inside this file
    // makes use of static methods, static variables, loops, exception handling and
    // more.
    // The code below has NOT been demonstrated by the professor as of the writing
    // of this note, so if you
    // do not understand the algorithm or logic below, do not worry too much for
    // they will be taught
    // eventually in the future (probably Programming 2).

    // Variables to hold user input, static so that they could be accessed by
    // methods directly
    static double inputOne = 0;
    static double inputTwo = 0;
    static char myOperator = ' ';
    static double myResult = 0;
    static boolean appOn = true;
    static int userChoice = 0;
    static float myResultFloat = 0;

    // Create a Scanner, static so that all methods in the class can use it
    static Scanner scanOne = new Scanner(System.in);

    public static void main(String[] args) {

        // We will now create a Basic Calculator using the Scanner class and Branching
        // Statements

        while (appOn) {

            mainMenu(); // loops mainMenu until loop is broken

        }

    }

    public static void mainMenu() { // method that contains our main menu

        resetNum(); // resets inputOne, inputTwo, myOperator, myResult, userChoice, myResultFloat
        System.out.println("=========================");
        System.out.println("[  2 Number Calculator  ]");
        System.out.println("[1] Calculator");
        System.out.println("[2] Area (Circle)");
        System.out.println("[3] Circumference (Circle)");
        System.out.println("[4] Close Application");
        System.out.println("=========================");

        try {

            System.out.print("Input: "); // asks for user input
            userChoice = scanOne.nextInt(); // stores it in userChoice

        }

        catch (InputMismatchException ex) { // runs if an exception occurs
            // an example of an exception is when you type letters instead of a number

            scanOne.nextLine(); // goes to default statement, loops to the start of the mainMenu method

        }

        switch (userChoice) { // switch case that uses userChoice

            case 1:
                userChoice = 0; // resets userChoice to zero
                calcMenu(); // goes to calcMenu method
                break;

            case 2:
                areaCalc(); // calculate the area of a circle
                break;

            case 3:
                circumCalc(); // calculate the circumference of the circle
                break;

            case 4:
                closeApp(); // closes the application
                break;

            default:
                System.out.println("[Invalid Input, Try Again]"); // prints when default occurs
                mainMenu(); // returns to mainMenu

        }

    }

    public static void calcMenu() { // runs if userInput is 1

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

        catch (InputMismatchException ex) { // executes when an exception occurs in any of the input process

            scanOne.nextLine(); // goes to default statement when an exception occurs

        }

        switch (myOperator) {

            case '+': // checks if myOperator is a + sign, will run code below if is is a + sign
                addNum(); // method that adds the two numbers
                break;

            case '-': // checks if myOperator is a - sign
                minNum(); // subtracts the two numbers
                break;

            case 'x': // checks if myOperator is a x sign
                mulNum(); // multiplies the two numbers
                break;

            case '/': // checks if myOperator is a / sign
                divNum(); // divides the two numbers
                break;

            default: // will run this if all cases return false
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(); // returns the user to mainMenu
                break;

        }

    }

    public static void addNum() { // method that adds numbers
        // no parameters needed since the variables are static

        myResult = inputOne + inputTwo;
        myResultFloat = (float) myResult; // makes the results shorter
        System.out.println("[Sum of the two numbers: " + myResultFloat + "]");

    }

    public static void minNum() { // subtracts numbers

        myResult = inputOne - inputTwo;
        myResultFloat = (float) myResult;
        System.out.println("[Difference of the two numbers: " + myResultFloat + "]");

    }

    public static void mulNum() { // multiplies numbers

        myResult = inputOne * inputTwo;
        myResultFloat = (float) myResult;
        System.out.println("[Product of the two numbers: " + myResultFloat + "]");

    }

    public static void divNum() { // divides numbers

        myResult = inputOne / inputTwo;
        myResultFloat = (float) myResult;
        System.out.println("[Quotient of the two numbers: " + myResultFloat + "]");

    }

    public static void closeApp() { // method that closes or stops the application

        scanOne.close(); // closes Scanner
        appOn = false; // breaks appOn while loop

    }

    public static void areaCalc() { // calculates the area of a circle using a radius

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input radius: ");
            inputOne = scanOne.nextDouble();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (Math.PI * Math.pow(inputOne, 2));
            myResultFloat = (float) myResult; // turns myResult into a float, we do this to get a shorter answer
            System.out.println("[Area (Circle): " + myResultFloat + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(); // returns to mainMenu

        }

    }

    public static void circumCalc() {

        try {

            System.out.println("[Input must be a Positive Integer (>0)]");
            System.out.print("Input radius: ");
            inputOne = scanOne.nextDouble();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to the else statement

        }

        if (inputOne > 0) {

            myResult = (2 * Math.PI * inputOne);
            myResultFloat = (float) myResult;
            System.out.println("Circumference (Circle): " + myResultFloat + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(); // returns to mainMenu

        }

    }

    public static void resetNum() { // method that resets certain values

        inputOne = 0;
        inputTwo = 0;
        myOperator = ' ';
        myResult = 0;
        userChoice = 0;
        myResultFloat = 0;

    }

}