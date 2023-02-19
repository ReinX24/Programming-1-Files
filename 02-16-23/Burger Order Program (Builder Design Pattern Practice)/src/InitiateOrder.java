import java.util.Scanner;

public class InitiateOrder {

    public static void main(String[] args) {

        /*
         * This will serve as the main class of the program, it will start by asking the
         * user if they want to order a burger and the program will go on if they choose
         * to order a burger.
         * 
         * This program will use the Builder Design Pattern where an object will be made
         * and the user will be prompted to specify attributes that they want for that
         * object.
         * 
         * In this case, we will be asking the user if they want a burger and will then
         * ask them for any additional information regarding the different ingredients
         * that could be inserted in the burger.
         */

        // TODO: create a orderInfo object that encapsulates the process below
        Scanner userInput = new Scanner(System.in);
        char userChoice;

        do {
            /* Ask the user if they want to order a burder */
            System.out.print("Do you want to order a burger? [y/n] : ");
            userChoice = userInput.next().charAt(0);

            /* If y, confirm order, create a burgerInfo object, & execute askInfo method */
            if (Character.toLowerCase(userChoice) == 'y') {
                /* Print confirmation message & ask for userName */
                System.out.println("[Confirmed!]");
                /* Asks the user to enter their name */
                System.out.print("Enter your name: ");
                String userName = userInput.nextLine();
                System.out.println("Order for " + userName + " coming right up!");
                 // TODO: create a burgerInfo class & constructor for the class for userName. 
                 // ! The userName should be used as a constructor for the bugerInfo constructor.
                userInput.close();
                return;
            } else if (Character.toLowerCase(userChoice) == 'n') {
                /* Cancels order & terminates program */
                System.out.println("[Cancelled!]");
                userInput.close();
                return;
            } else {
                /* If the userChoice in invalid */
                System.out.println("[Invalid Input, Restarting Program]");
            }
        } while (Character.toLowerCase(userChoice) != 'n');

        userInput.close();

    }

}