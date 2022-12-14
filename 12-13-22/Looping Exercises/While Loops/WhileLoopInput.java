import java.util.Scanner;

public class WhileLoopInput {

    public static void main(String[] args) {

        /*
         * Accept an integer, the integer is our loop amount
         * Use a while loop to complete this exercise
         * 
         */

        // Scanner to accept input
        Scanner scanOne = new Scanner(System.in);

        // Ask user for a number
        System.out.print("Loop Amount: ");
        int loopNum = scanOne.nextInt();

        // Variable that holds our message and current loop number
        String loopMsg = "Turing Loop: ";

        // Loop the message in respect to our number input using a while loop

        while (loopNum > 0) { // while loopNum is greater than 0, run the code below

            System.out.println(loopMsg + loopNum); // prints our message along with the current loop number
            loopNum--; // decrements loopNum by one

        }

        scanOne.close(); // closes the Scanner

    }

}
