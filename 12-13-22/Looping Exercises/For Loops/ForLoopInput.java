import java.util.Scanner;

public class ForLoopInput {

    public static void main(String[] args) {
        
        /*
         * Input a number, this number will be the amount of times the message will be looped.
         * Message - "Kentucky Fried Chicken"
         * 
         */

        // Scanner object that will accept user input
        Scanner scanOne = new Scanner(System.in);

        // Create our String for our message
        String myMessage = "Kentucky Fried Chicken";

        // Ask the user the amount of times the for loop will run
        System.out.print("Input loop amount: ");
        int loopNum = scanOne.nextInt();

        // Loop message in respect with the number that user inputted
        for (int i = 0; i < loopNum; i++) { // loops until less than inputted number
        // remember that we start counting from 0, so if we input 3, it will count as 0, 1, 2 then stop loop at 3

            System.out.println(myMessage); // iterations printed will depend on inputted number

        }

        scanOne.close(); // closes the Scanner

    }
    
}
