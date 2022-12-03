import java.util.Scanner;

public class LegalAgeExercise {

    public static void main(String[] args) {

        // We will now create code that will accept a number,
        // will check if that number is above legal age or 18,
        // and return the result

        // Make a Scanner first
        Scanner scanOne = new Scanner(System.in);

        // Make a variable that holds your input
        int myAge = 0;

        // Ask the user for their input
        System.out.print("Input age: ");
        myAge = scanOne.nextInt(); // assigns user input in myAge

        // The user input will now go through branching statements

        if (myAge < 18) {
            // Checks if myAge or user input is less than 18
            System.out.println("[Your age is below 18]");
            System.out.println("[You are still a minor]");

        }

        else if (myAge >= 18) {
            // Checks if myAge or user input is greater than of less than 18
            System.out.println("[Your age is either 18 or above]");
            System.out.println("[You are now an adult]");

        }

        scanOne.close(); // closes the Scanner

    }

}
