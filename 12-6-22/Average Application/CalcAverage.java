import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcAverage {

    Scanner scanOne = new Scanner(System.in); // Scanner that will accept user input
    ArrayList<Float> numArr = new ArrayList<Float>(); // ArrayList where values will be stored
    int userChoice = 0; // stores userChoice
    Float numUserAdd = null;

    public void mainMenu() {

        userChoice = 0; // resets user choice to avoid bugs, an example is when it takes the
        // last input as userChoice as a decision when an exception is supposed to occur
        System.out.println("====================");
        System.out.println("[Average Calculator]");
        System.out.println("====================");
        System.out.println("[1] Add No. to Array");
        System.out.println("[2] Clear Array");
        System.out.println("[3] Show Array");
        System.out.println("[4] Exit Application");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
                addNumMenu();
                break;

            case 2:
                deleteArrMenu(); // menu for clearing Array List
                break;

            case 3:
                showArr();
                break;

            case 4:
                exitApp(); // exits application
                break;

            default:
                mainMenu(); // returns to main menu
                break;

        }

    }

    public void addNumMenu() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("[Add Number to Array]");
        System.out.println("[1] Add a Number");
        System.out.println("[2] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
                addNumChoice(); // goes to a menu where the user inputs a number
                break;

            case 2:
                mainMenu(); // returns to main menu
                break;

            default:
                errorReset(); // says an error message an returns to main menu
                break;

        }

    }

    public void addNumChoice() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("[Insert No. to Add]");

        try {

            System.out.print("Input number: ");
            Double numHolder = scanOne.nextDouble(); // numHolder will hold our input

            numUserAdd = numHolder.floatValue(); // assigns the float value of numHolder to numUserAdd

            if (numUserAdd == numHolder.floatValue()) { // checks in numUserAdd has the same float value of numHolder

                addNum(numUserAdd);
                System.out.println("Number added!"); // tells user their number has been added
                addNumMenu(); // return to menu before

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            errorReset();

        }

    }

    public void addNum(Float paramNum) { // method that adds inputted number to the ArrayList

        numArr.add(paramNum);

    }

    public void deleteArrMenu() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("[Clear Array Elements]");
        System.out.println("Current Array: ");
        System.out.println(numArr);

        System.out.println("[1] Clear Array");
        System.out.println("[2] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        if (userChoice == 1) {

            numArr.removeAll(numArr);
            System.out.println("Cleared Array!");

        }

        else {

            errorReset();

        }

    }

    public void showArr() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[1] Sort Array");
        System.out.println("[2] Return to Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
                sortArray(); // method that sorts the array
                break;

            case 2:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void sortArray() {

        try {

            Collections.sort(numArr); // sorts the array
            System.out.println("====================");
            System.out.println("Sorting array...");
            Thread.sleep(3000); // delays printing next line
            System.out.println("Array sorted!");
            showArr(); // shows Array List but sorted this time
        }

        catch (InterruptedException ex) {

            ex.printStackTrace();

        }

    }

    public void errorReset() {

        System.out.println("[Error Occured, Returning to Main Menu]");
        mainMenu(); // return to main menu

    }

    public void exitApp() {

        System.out.println("[Exited Application]");
        System.exit(0);

    }

}
