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
        System.out.println("[3] Show|Sort Array");
        System.out.println("[4] Average of Array");
        System.out.println("[5] Median of Array");
        System.out.println("[6] Exit Application");
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
                showArr(); // menu that shows elements, also gives option to sort Array List
                break;

            case 4:
                aveMenu(); // method that goes to a menu that shows array list elements and prompts the
                break;

            case 5:
                medianMenu(); // method that goes to median menu
                break;

            case 6:
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
        System.out.println("[2] Description");
        System.out.println("[3] Main Menu");
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
                addDesc(); // method that shows adding elements description
                break;

            case 3:
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
        System.out.println("====================");
        System.out.println("[1] Clear Array");
        System.out.println("[2] Description");
        System.out.println("[3] Main Menu");
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
                deleteArr();
                break;

            case 2:
                deleteDesc();
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void deleteArr() {

        try {

            System.out.println("Removing numbers...");
            Thread.sleep(1500); // 1.5 sec delay
            numArr.removeAll(numArr);
            System.out.println("Cleared Array!");

        }

        catch (InterruptedException ex) {

            errorReset();

        }

    }

    public void showArr() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[Sort Array Elements]");
        System.out.println("[1] Sort Array");
        System.out.println("[2] Description");
        System.out.println("[3] Main Menu");
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
                sortDesc(); // method that shows sorting descrition
                break;

            case 3:
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
            Thread.sleep(1500); // delays printing next line, 1.5 seconds
            System.out.println("Array sorted!");
            showArr(); // shows Array List but sorted this time
        }

        catch (InterruptedException ex) {

            errorReset();

        }

    }

    // Average calculator menu
    public void aveMenu() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[Array List Average]");
        System.out.println("[1] Find Average");
        System.out.println("[2] Description");
        System.out.println("[3] Main Menu");
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
                calcAverage(); // method that calculates average
                break;

            case 2:
                aveDesc(); // method that shows description of calculating average
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void calcAverage() { // calculates for average

        try {

            Float sumOfNum = 0.0f; // stores the sum of all numbers
            Float arrAverage = 0.0f; // stores the average

            for (int i = 0; i < numArr.size(); i++) {

                sumOfNum = sumOfNum + numArr.get(i);

            }

            arrAverage = sumOfNum / numArr.size(); // calculates for average

            System.out.println("====================");
            System.out.println("Adding numbers...");
            Thread.sleep(1000); // delays printing next line, 1 second
            System.out.println("Finding average...");
            Thread.sleep(1000); // delays printing next line, 1 second
            System.out.println("Average found!");
            System.out.println("Average: " + arrAverage);
        }

        catch (InterruptedException ex) {

            errorReset();

        }

    }

    // Calculates for Median menu
    public void medianMenu() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[Array List Median]");
        System.out.println("[1] Find Median");
        System.out.println("[2] Description");
        System.out.println("[3] Main Menu");
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
                calcMedian(); // method that calculates or finds median
                break;

            case 2:
                medDesc(); // method that shows description of finding median
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void calcMedian() { // calculates for median

        try {

        if (numArr.size() % 2 != 0) { // odd number size

            ArrayList<Float> arrClone = new ArrayList<Float>(numArr); // clones our array list to another array list
            Collections.sort(arrClone); // sorts cloned array list
            Float medianFloat = 0.0f; // stores median
            System.out.println("Finding median...");
            Thread.sleep(1000); // 1 second delay
            medianFloat = arrClone.get((arrClone.size() - 1) / 2); 
            System.out.println("Median found!");
            System.out.println("Median: " + medianFloat);

        }

        else { // even number size

            ArrayList<Float> arrClone = new ArrayList<Float>(numArr); // clones our array list to another array list
            Collections.sort(arrClone); // sorts cloned array list
            Float medianFloat = 0.0f; // stores median
            System.out.println("Finding median...");
            Thread.sleep(1000); // 1 second delay
            medianFloat = (arrClone.get(arrClone.size() / 2) + arrClone.get(arrClone.size() / 2 - 1)) / 2; 
            System.out.println("Median found!");
            System.out.println("Median: " + medianFloat);

        }

    }

        catch (InterruptedException ex) {

            errorReset();

        }

    }

    public void addDesc() { // Add element description

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Add element to our");
        System.out.println("set of numbers.");
        System.out.println("====================");
        System.out.println("[2] Back");
        System.out.println("[3] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 2:
                addNumMenu();
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void deleteDesc() { // Clear entire array description

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Clear all elements");
        System.out.println("in our number set.");
        System.out.println("====================");
        System.out.println("[2] Back");
        System.out.println("[3] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 2:
                deleteArrMenu();
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void sortDesc() { // Sorting the elements description

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Sorts all elements");
        System.out.println("in our number set in");
        System.out.println("ascending order.");
        System.out.println("====================");
        System.out.println("[2] Back");
        System.out.println("[3] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 2:
                showArr();
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    // Finding the average description
    public void aveDesc() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Finds the average");
        System.out.println("of our number set.");
        System.out.println("====================");
        System.out.println("[2] Back");
        System.out.println("[3] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 2:
                aveMenu();
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void medDesc() { // description for median

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Finds the median");
        System.out.println("of our number set.");
        System.out.println("====================");
        System.out.println("[2] Back");
        System.out.println("[3] Main Menu");
        System.out.println("====================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 2:
                medianMenu(); // returns to median menu
                break;

            case 3:
                mainMenu(); // returns to main menu
                break;

            default:
                errorReset();
                break;

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
