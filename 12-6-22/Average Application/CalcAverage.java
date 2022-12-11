import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
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
        System.out.println("[Measure of Central Tendency Calculator]");
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[1] Add No. to Array");
        System.out.println("[2] Clear Array");
        System.out.println("[3] Sort Array");
        System.out.println("[4] Average of Array");
        System.out.println("[5] Median of Array");
        System.out.println("[6] Mode of Array");
        System.out.println("[7] Exit Application");
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
                modeMenu(); // method that goes to mode menu
                break;

            case 7:
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
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
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

            if (numArr.size() > 1) {

                arrAverage = sumOfNum / numArr.size(); // calculates for average

                System.out.println("====================");
                System.out.println("Adding numbers...");
                Thread.sleep(1000); // delays printing next line, 1 second
                System.out.println("Finding average...");
                Thread.sleep(1000); // delays printing next line, 1 second
                System.out.println("Average found!");
                System.out.println("Average: " + arrAverage);

            }

            else {

                System.out.println("No average found!");
                System.out.println("[Need more numbers]");

            }

            mainMenu(); // return to main menu
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

            if (numArr.size() > 1) {

                if (numArr.size() % 2 != 0) { // odd number size

                    ArrayList<Float> arrClone = new ArrayList<Float>(numArr); // clones our array list to another array
                                                                              // list
                    Collections.sort(arrClone); // sorts cloned array list
                    Float medianFloat = 0.0f; // stores median
                    System.out.println("Finding median...");
                    Thread.sleep(1000); // 1 second delay
                    medianFloat = arrClone.get((arrClone.size() - 1) / 2);
                    System.out.println("Median found!");
                    System.out.println("Median: " + medianFloat);

                }

                else { // even number size

                    ArrayList<Float> arrClone = new ArrayList<Float>(numArr); // clones our array list to another array
                                                                              // list
                    Collections.sort(arrClone); // sorts cloned array list
                    Float medianFloat = 0.0f; // stores median
                    System.out.println("Finding median...");
                    Thread.sleep(1000); // 1 second delay
                    medianFloat = (arrClone.get(arrClone.size() / 2) + arrClone.get(arrClone.size() / 2 - 1)) / 2;
                    System.out.println("Median found!");
                    System.out.println("Median: " + medianFloat);

                }

            }

            else {

                System.out.println("No median found!");
                System.out.println("[Need more numbers]");

            }

            mainMenu(); // return to main menu

        }

        catch (InterruptedException ex) {

            errorReset();

        }

    }

    public void modeMenu() {

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Array List Contents:");
        System.out.println(numArr);
        System.out.println("====================");
        System.out.println("[Array List Mode]");
        System.out.println("[1] Find Mode");
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
                calcMode(); // method that calculates or finds median
                break;

            case 2:
                modeDesc(); // method that shows description of finding moe
                break;

            case 3:
                mainMenu();
                break;

            default:
                errorReset();
                break;

        }

    }

    public void calcMode() { // calculates for mode

        try {

            if (numArr.size() > 1) {

                ArrayList<Float> arrClone = new ArrayList<Float>(numArr); // clones original array list
                LinkedHashSet<Float> modeSet = new LinkedHashSet<Float>(); // LinkedHashSet holds our mode/s
                // LinkedHashSet because this type of Set merges any duplicates in its Set
                System.out.println("Finding mode/s...");
                Thread.sleep(1000); // 1 second delay

                // Finding our mode

                Float modeNum = 0.0f; // stores indiv median to add to modeSet
                int maxCount = 0; // max count of our mode

                for (int i = 0; i < arrClone.size(); i++) { // loops through list

                    int numCounter = 0; // stores how many times a number is similar to another number

                    for (int j = 0; j < arrClone.size(); j++) { // another loop that goes through our list

                        if (arrClone.get(i).equals(arrClone.get(j))) { // .equals for array list elements
                            // if the iterated number is similar to the second iterated number, increment
                            // numCounter by one
                            ++numCounter;

                        }

                    }

                    // After inner for loop is broken, check if he current value is more frequent
                    // than any
                    // of the previous values

                    if (numCounter > maxCount && numCounter >= 2) { // mode must occur 2 or more times

                        modeNum = arrClone.get(i); // assigns current number to be the mode
                        maxCount = numCounter; // counter of this number replaces old max count
                        modeSet.removeAll(modeSet); // removes all past element since new number replaces these elements
                        modeSet.add(modeNum); // adds current found mode

                    }

                    // If the current value has an equal count to our last

                    else if (numCounter == maxCount && numCounter >= 2) {

                        modeNum = arrClone.get(i);
                        modeSet.add(modeNum);

                    }

                } // end of outer for loop

                if (modeSet.size() > 0) { // if there are any modes, print elements

                    System.out.println("Mode/s found!");
                    System.out.println("Mode/s: " + modeSet);

                }

                else {

                    System.out.println("No mode found!");
                    System.out.println("[None of the elements repeat]");

                }

            }

            mainMenu(); // returns to main menu after all operations executed

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

    public void modeDesc() { // description for mode

        userChoice = 0;
        System.out.println("====================");
        System.out.println("Description: ");
        System.out.println("> Finds the mode of");
        System.out.println("our number set.");
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
                modeMenu(); // returns to mode menu
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
