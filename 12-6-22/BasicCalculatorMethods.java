import java.util.InputMismatchException; // import for handling InputMismatchExceptions
import java.util.Scanner; // import for Scanner class

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/6/22
 * School: Universidad De Dagupan
 * Description: Basic Calculator with Methods, Parameters, Loops, and Exception Handling
 * 
 */

class BasicCalculatorMethods {

    /*
     * NOTE: This is an advanced version of the Basic Java Calculator exercise, the
     * code inside this file makes use of static methods, static variables, loops,
     * exception handling and more.
     * 
     * The code below has NOT been demonstrated by the professor as of the writing
     * of this note, so if you do not understand the algorithm or logic below, do
     * not worry too much for they will be taught eventually in the future
     * (probably Programming 2).
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
     * the mainMenu performs an operation or an exception occurs, it returns to
     * mainMenu and all of the variables are reset since the original variable
     * values are not modified through the methods. This is except for the appOn
     * variable, where its value could be directly changed if the user closes
     * the application.
     * 
     */

    public static void main(String[] args) {

        // Scanner to accept user input
        Scanner scanOne = new Scanner(System.in);

        // Placed variables inside main method to make use of parameters
        // All the values reset to values in the main method after an operation within
        // another method
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
            // we will be using all of the variables inserted as parameters for the entirety
            // of our program
            // the appOn in the main method will be reassigned to the new boolean from the
            // mainMenu method

        }

        if (appOn == false) {

            scanOne.close(); // closes the Scanner after the while loop is broken and appOn is false

        }

    }

    public static boolean mainMenu(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // method that contains our main menu
        // All variables are inside the parameters since we will be using them
        // throughout our various methods

        userChoice = 0; // resets userChoice when mainMenu is invoked, for avoiding bugs
        System.out.println("=========================");
        System.out.println("[  2 Number Calculator  ]"); // these will be the "interface" of our main menu
        System.out.println("[1] 2 No. Calculator");
        System.out.println("[2] Circle Calculator");
        System.out.println("[3] Pythagorean Theorem");
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

        switch (userChoice) { // switch case that has userChoice as its variable

            case 1:
                // goes to calcMenu method
                calcMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 2:
                // goes to circle calculator
                cirCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);

            case 3:
                // pythagorean theorem calculator
                pythaCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 4:
                appOn = closeApp(appOn); // closes the application by making appOn false
                // the result of appOn will then return to the main method through the mainMenu
                // method
                break;

            default:
                System.out.println("[Invalid Input, Try Again]"); // prints when default occurs
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

        return appOn; // returns appOn, returns false only when the user choices to close the app

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

        }

        catch (InputMismatchException ex) { // executes when an exception occurs in any of the input process

            scanOne.nextLine(); // goes to default statement when an exception occurs

        }

        // We will now use the Switch case syntax for our calculator
        // We will use the Switch case rather than the If - else if - nested if syntax
        // so that we could demonstrate how the Switch case works

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

    public static void cirCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) {

        userChoice = 0;
        System.out.println("[Circle Calculator]");
        System.out.println("[1] Radius");
        System.out.println("[2] Area");
        System.out.println("[3] Circumference");
        System.out.println("[4] Diameter");
        System.out.println("[5] Main Menu");
        System.out.println("=========================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt(); 

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
                // calculate the radius of a circle using inputted area, circumference, or
                // diameter
                radiCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 2:
                // calculate the area of a circle
                areaCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 3:
                // calculate the circumference of a circle
                circumCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 4:
                // calculate the diameter of a circle
                diamCalc(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            case 5:
                // returns to main menu
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

            default:
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

        }

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
            // calculates radius using area
                radiCalcArea(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); 
                break;

            case 2:
             // calculates radius using circumference
                radiCalcCircum(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);                                                                         
                break;

            case 3:
            // calculates radius using diameter
                radiCalcDiam(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);                                                                              
                break;

            default:
                System.out.println("[Error Occurred, Try Again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void radiCalcArea(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using area

        try {

            System.out.println("[Input must be a Positive Integer (>0)]"); // user input must be greater than 0
            System.out.print("Input area: ");
            inputOne = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // goes to else statement if an exception occurs

        }

        if (inputOne > 0) {

            myResult = (float) (Math.sqrt(inputOne / Math.PI)); // converts the result to a float,
            // this is because using methods in the Math class return a double value
            System.out.println("[Radius (Circle): " + myResult + "]");

        }

        else {

            System.out.println("[Error Occurred, Try Again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); // returns to mainMenu

        }

    }

    public static void radiCalcCircum(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using circumference

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
            Scanner scanOne, boolean appOn) { // calculates the radius of a circle using diameter

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

    // Pythagorean Theorem calculator
    public static void pythaCalc(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
    Scanner scanOne, boolean appOn) {

        userChoice = 0;
        System.out.println("[Pythagorean Theorem Calculator]");
        System.out.println("[1] Hypotenuse");
        System.out.println("[2] Perpendicular (A leg)");
        System.out.println("[3] Base (B leg)");
        System.out.println("[4] Main Menu");
        System.out.println("================================"); 

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine(); // will lead to defualt case and go back to main menu

        }

        switch (userChoice) {

            case 1:
                hypotenuseCalculate(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;
            case 2:
                perpendicularCalculate(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;
            case 3:
                // baseCalculate(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;
            case 4:
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;
            default:
                System.out.println("[Invalid Input, try again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
                break;

        }

    }

    // Calculates for hypotenuse
    public static void hypotenuseCalculate(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
    Scanner scanOne, boolean appOn) {

        try {

            // Asking user for values
            System.out.print("Input Perpendicular or A leg: ");
            inputOne = scanOne.nextFloat();

            System.out.print("Input Base or B leg: ");
            inputTwo = scanOne.nextFloat();

        }

        catch (InputMismatchException ex) { // executes catch block first before the else block

            scanOne.nextLine();

        }

        // Calculate the hypotenuse
        myResult = (float) Math.sqrt(Math.pow(inputOne, 2) + Math.pow(inputTwo, 2)); // for calculating the hypotenus

        if (myResult != 0) { // it is impossible for a hypotenuse to have a length of zero

            System.out.printf("The hypotenuse of triangle: %.2f\n", myResult); // roounded off to 2 decimal places

        }

        else {

            System.out.println("[Not a valid input, try again]");
            mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);

        }

    }

        // Calculate the perpendicular
        public static void perpendicularCalculate(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
        Scanner scanOne, boolean appOn) {

            try {
    
                System.out.print("Input Base or B leg: ");
                inputOne = scanOne.nextFloat();
    
                System.out.print("Input Hypotenuse or C leg: ");
                inputTwo = scanOne.nextFloat();
    
            }
    
            catch (InputMismatchException ex) {
    
                scanOne.nextLine(); // goes to else block
    
            }
    
            if (inputTwo > inputOne) { // hypotenuse needs to be longer than base
    
                myResult = (float) Math.sqrt(Math.pow(inputTwo, 2) - Math.pow(inputOne, 2));
    
                System.out.printf("The perpendicular of triangle: %.2f\n", myResult); // shows the perpendicular of the trangle
    
            }
    
            else if (inputTwo <= inputOne) {
    
                System.out.println("[Invalid input, the hypotenuse must be greater than the base]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
    
            }
    
            else { // executes when an exception occurs
    
                System.out.println("[Not a valid input, try again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
    
            }
    
        }

        // Calculate the base
        public static void baseCalculate(int userChoice, float inputOne, float inputTwo, char myOperator, float myResult,
        Scanner scanOne, boolean appOn) {

            try {
    
                System.out.print("Input Perpendicular or A leg: ");
                inputOne = scanOne.nextFloat();
    
                System.out.print("Input Hypotenuse or C leg: ");
                inputTwo = scanOne.nextFloat();
    
            }
    
            catch (InputMismatchException ex) {
    
                System.out.println("[Not a valid input, try again]");
                scanOne.nextLine(); // goes to else block
    
            }
    
            if (inputTwo > inputOne) { // hypotenuse needs to be longer than the perpendicular
    
                myResult = (float) Math.sqrt(Math.pow(inputTwo, 2) - Math.pow(inputOne, 2));
    
                System.out.printf("The base of triangle: %.2f\n", myResult);
    
            }
    
            else if (inputTwo <= inputOne) {
    
                System.out.println("[Invalid input, the hypotenuse must be greater than the perpendicular]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn);
    
            }
    
            else {
    
                System.out.println("[Not a valid input, try again]");
                mainMenu(userChoice, inputOne, inputTwo, myOperator, myResult, scanOne, appOn); 
    
            }
    
        }

    // closes the application
    public static boolean closeApp(boolean appOn) { // method that closes or stops the application

        System.out.println("[Application Closed]");
        appOn = false; // breaks appOn while loop
        return appOn; // returns appOn as false

    }

    // method that resets certain values, commented out for now
    // public static void resetNum(int userChoice, float inputOne, float inputTwo,
    // char myOperator, float myResult) {

    // inputOne = 0;
    // inputTwo = 0;
    // myOperator = ' ';
    // myResult = 0;
    // userChoice = 0;

    // }

}