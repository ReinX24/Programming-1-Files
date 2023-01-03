import java.util.InputMismatchException;
import java.util.Scanner;

class BasicCalculatorMethods {

    // Creating varibles

    // Static variables since they will be used outside the main method and other
    // methods

    static float numOne;
    static float numTwo;
    static char mySymbol;
    static float myResult = 0;
    static int userChoice = 0;
    static boolean appOn = true;

    static Scanner scanOne = new Scanner(System.in); // Creating a Basic Java Caculator

    public static void main(String[] args) {

        while (appOn) {

            mainMenu(); // calls the mainMenu() method

        }

    }

    public static void mainMenu() {

        try {

            System.out.println("--------------------------------");
            System.out.println("[1] 2 Number Calculator");
            System.out.println("[2] Close Application");
            System.out.println("--------------------------------");
            System.out.print("User Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            System.out.println("[Invalid input, try again]");
            scanOne.nextLine(); // goes to default statement

        }

        switch (userChoice) {

            case 1:
                userChoice = 0;
                calcMenu();
                break;

            case 2:
                closeApp();
                break;

            default:
                mainMenu();
                break;

        }

    }

    public static void calcMenu() {

        try {

            System.out.println("--------------------------------");
            System.out.print("Enter 1st no?: ");
            numOne = scanOne.nextFloat();

            System.out.println("--------------------------------");
            System.out.print("Enter 2nd no?: ");
            numTwo = scanOne.nextFloat();

            System.out.println("--------------------------------");
            System.out.print("Enter Symbol(+,-,/,*)?: ");
            mySymbol = scanOne.next().charAt(0);

        }

        catch (InputMismatchException ex) {

            System.out.println("[Invalid input, try again]");
            scanOne.nextLine(); // goes to default statement

        }

        System.out.println("--------------------------------");

        switch (mySymbol) {

            case '+':
                addNum(myResult, numOne, numTwo);
                resetNum(); // resets all of the numbers after a code block within a case runs
                break;

            case '-':
                minNum(myResult, numOne, numTwo);
                resetNum();
                break;

            case 'x':
                mulNum(myResult, numOne, numTwo);
                resetNum();
                break;

            case '/':
                divNum(myResult, numOne, numTwo);
                resetNum();
                break;

            default:
                invalidOperator(); // if the operator is invalid or an exception occurs, return to mainMenu()
                break;

        }

    }

    // Method that adds the two numbers
    public static void addNum(float myResult, float numOne, float numTwo) {

        myResult = numOne + numTwo;
        System.out.println("[Sum: " + myResult + "]");

    }

    // Method that subtracts the two numbers
    public static void minNum(float myResult, float numOne, float numTwo) {

        myResult = numOne - numTwo;
        System.out.println("[Difference: " + myResult + "]");

    }

    // Method that multiplies the two numbers
    public static void mulNum(float myResult, float numOne, float numTwo) {

        myResult = numOne * numTwo;
        System.out.println("[Product: " + myResult + "]");

    }

    // Method that divides the two numbers
    public static void divNum(float myResult, float numOne, float numTwo) {

        myResult = numOne / numTwo;
        System.out.println("[Quotient: " + myResult + "]");

    }

    // Returns to mainMenu() if an exception occurs
    public static void invalidOperator() {

        System.out.println("[Symbol not recognized]");
        resetNum(); // resets all the numbers
        mainMenu(); // returns user to mainMenu()

    }

    public static void closeApp() {

        System.out.println("[Application turned off]");
        appOn = false; // breaks while loop that keeps the app running
        scanOne.close(); // closes Scanner

    }

    public static void resetNum() {

        myResult = 0;
        numOne = 0;
        numTwo = 0;
        mySymbol = ' ';

    }

}