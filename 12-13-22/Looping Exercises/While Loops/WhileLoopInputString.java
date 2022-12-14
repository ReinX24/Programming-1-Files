import java.util.Scanner;

public class WhileLoopInputString {

    public static void main(String[] args) {

        /*
         * Accept a String and an integer, the String will be your message to be printed
         * and the integer will be the amount of iterations the loop will have.
         * Do this using a while loop
         * 
         */

        // Scanner object that will accept our inputs
        Scanner scanOne = new Scanner(System.in);

        // Ask for a message that we will be looping
        System.out.print("Input Message: ");
        String loopMessage = scanOne.nextLine();

        // Ask for a number that will be our loop amount
        System.out.print("Input Amount: ");
        int loopAmount = scanOne.nextInt();

        // While loop that loops message in respect to loop amount

        while (loopAmount > 0) {

            System.out.println(loopMessage);
            loopAmount--;

        }

        scanOne.close(); // closes the Scanner

    }

}