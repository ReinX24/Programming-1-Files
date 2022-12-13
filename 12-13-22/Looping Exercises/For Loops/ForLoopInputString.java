import java.util.Scanner;

public class ForLoopInputString {

    public static void main(String[] args) {
        
        /*
         * Create a program that accepts a message and a number that will represent
         * how many times that message will be looped.
         * 
         */

        // Create Scanner object to accept input
        Scanner scanOne = new Scanner(System.in);

        // Ask for the message to be inputted
        System.out.print("Input message: ");
        String userMessage = scanOne.nextLine();

        // Ask for the loop amount
        System.out.print("Input loop amount: ");
        int userLoop = scanOne.nextInt();

        // Loop the message in respect to inputted number

        for (int i = 0; i < userLoop; i++) {

            System.out.println(userMessage);

        }

        scanOne.close(); // closes the Scanner

    }
    
}
