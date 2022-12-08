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

    /*
     * NOTE: This is an advanced version of the Basic Java Calculator exercise, the
     * code inside this file
     * makes use of static methods, static variables, loops, exception handling and
     * more.
     * The code below has NOT been demonstrated by the professor as of the writing
     * of this note, so if you
     * do not understand the algorithm or logic below, do not worry too much for
     * they will be taught
     * eventually in the future (probably Programming 2).
     * 
     */

    /*
     * 12/8/22 moved the static variables within the main method to make use of
     * parameters.
     * 
     * The code resulted to being somewhat less readable than before since we used
     * the parameters of the methods that we have made.
     * 
     * Also removed the method that resets all the numbers, this is because after
     * the
     * mainMenu performs an operation or an exception occurs, it returns to mainMenu
     * and all of the variables are reset since the original variable values are not
     * modified through the methods. This is except for the appOn variable, where
     * its
     * value could be directly changed if the user closes the application.
     * 
     */

    public static void main(String[] args) {

        // Scanner to accept user input
        Scanner scanOne = new Scanner(System.in);

        // Placed variables inside main method to make use of parameters
        // Apparently, all the values reset to values in the main method after an
        // operation within the mainMenu method
        float inputOne = 0;
        float inputTwo = 0;
        char myOperator = ' ';
        float myResult = 0;
        int userChoice = 0;
        boolean appOn = true;

        // We will now create a Basic Calculator using the Scanner class and Branching
        // Statements

        while (appOn) { // loops mainMenu until appOn is false

            appOn = mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
            // the appOn in the main method will be reassigned to the new boolean from the
            // mainMenu method

        }

        scanOne.close(); // closes the Scanner

    }

    public static boolean mainMenu(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // method that contains our main menu

        userChoice = 0;
        System.out.println("=========================");
        System.out.println("[  2 Number Calculator  ]");
        System.out.println("[1] Calculator");
        System.out.println("[2] Radius (Circle)");
        System.out.println("[3] Area (Circle)");
        System.out.println("[4] Circumference (Circle)");
        System.out.println("[5] Diameter (Circle)");
        System.out.println("[6] Close Application");
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
                // goes to calcMenu method
                calcMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 2:
                // calculate the radius of a circle
                radiCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 3:
                // calculate the area of a circle
                areaCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 4:
                // calculate the circumference of a circle
                circumCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 5:
                // calculate the diameter of a circle
                diamCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 6:
                appOn = closeApp(appOn, scanOne); // closes the application by making appOn false
                // the result of appOn will then return to the main method
                break;

            default:
                System.out.println("[Invalid Input, Try Again]"); // prints when default occurs
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

        return appOn; // returns appOn

    }

    public static void calcMenu(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // runs if userInput is 1

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
                addNum(inputOne, inputTwo, myResult); // method that adds the two numbers
                break;

            case '-': // checks if myOperator is a - sign
                minNum(inputOne, inputTwo, myResult); // subtracts the two numbers
                break;

            case 'x': // checks if myOperator is a x sign
                mulNum(inputOne, inputTwo, myResult); // multiplies the two numbers
                break;

            case '/': // checks if myOperator is a / sign
                divNum(inputOne, inputTwo, myResult); // divides the two numbers
                break;

            default: // will run this if all cases return false
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // mainMenu
                break;

        }

    }

    public static void addNum(float inputOne, float inputTwo, float myResult) { // method that adds numbers
        // no parameters needed since the variables are static

        myResult = inputOne + inputTwo;
        System.out.println("[Sum of the two numbers: " + myResult + "]");

    }

    public static void minNum(float inputOne, float inputTwo, float myResult) { // subtracts numbers

        myResult = inputOne - inputTwo;
        System.out.println("[Difference of the two numbers: " + myResult + "]");

    }

    public static void mulNum(float inputOne, float inputTwo, float myResult) { // multiplies numbers

        myResult = inputOne * inputTwo;
        System.out.println("[Product of the two numbers: " + myResult + "]");

    }

    public static void divNum(float inputOne, float inputTwo, float myResult) { // divides numbers

        myResult = inputOne / inputTwo;
        System.out.println("[Quotient of the two numbers: " + myResult + "]");

    }

    public static void radiCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle

        userChoice = 0;
        System.out.println("[Calculate Radius]");
        System.out.println("[1] Area");
        System.out.println("[2] Circumference");
        System.out.println("[3] Diameter");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        switch (userChoice) {

            case 1:
                radiCalcArea(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 2:
                radiCalcCircum(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 3:
                radiCalcDiam(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            default:
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void radiCalcArea(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using a radius

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input area: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (float) (Math.sqrt(inputOne / Math.PI));
            System.out.println("[Radius (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void radiCalcCircum(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using a radius

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input circumference: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (float) (inputOne / (2 * Math.PI));
            System.out.println("[Radius (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void radiCalcDiam(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using a radius

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input diameter: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (float) (inputOne / 2);
            System.out.println("[Radius (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void areaCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the area of a circle using a radius

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input radius: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (float) (Math.PI * Math.pow(inputOne, 2));
            System.out.println("[Area (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void circumCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // circumference of the circle

        try {

            System.out.println("[Input must be a Positive Integer (>0)]");
            System.out.print("Input radius: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to the else statement

        }

        if (inputOne > 0) {

            myResult = (float) (2 * Math.PI * inputOne);
            System.out.println("Circumference (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void diamCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // diameter of the circle

        try {

            System.out.println("[Input must be a Positive Integer (>0)]");
            System.out.print("Input radius: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to the else statement

        }

        if (inputOne > 0) {

            myResult = (float) (2 * inputOne);
            System.out.println("Diameter (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    // closes the application
    public static boolean closeApp(boolean appOn, Scanner scanOne) { // method that closes or stops the application

        System.out.println("[Application Closed]");
        appOn = false; // breaks appOn while loop
        return appOn; // returns appOn as false

    }

    // method that resets certain values, commented out for now
    // public static void resetNum(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult) {

    //     inputOne = 0;
    //     inputTwo = 0;
    //     myOperator = ' ';
    //     myResult = 0;
    //     userChoice = 0;

    // }

}