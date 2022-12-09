import java.util.ArrayList;
import java.util.Scanner;

public class CalcAverage {

    Scanner scanOne = new Scanner(System.in); // Scanner that will accept user input
    ArrayList<Float> numArr = new ArrayList<Float>(); // ArrayList where values will be stored
    int userChoice = 0; // stores userChoice
    Float numUserAdd = 0.0f;

    public void mainMenu() {

        System.out.println("[Average Calculator]");
        System.out.println("[1] Add Number to Array");
        System.out.println("[2] Clear Array");
        System.out.println("[3] Show Array");
        System.out.println("[4] Exit Application");
        System.out.print("Input: ");

        userChoice = scanOne.nextInt();

        switch (userChoice) {

            case 1:
            addNumMenu();
            break;

            case 2:
            // method that resets array
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

        System.out.println("[1] Add a Number to Array");
        System.out.println("[2] Main Menu");
        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        if (userChoice == 1) {

            System.out.print("Input number: ");
            numUserAdd = scanOne.nextFloat();
            addNum(numUserAdd);

        }

        else {

            mainMenu(); // returns to main menu

        }

    }

    public void addNum(Float paramNum) {

        numArr.add(paramNum);

    }

    public void showArr() {

        System.out.println(numArr);

    }

    public void exitApp() {

        System.out.println("Exited Application");
        System.exit(0);

    }
    
}
