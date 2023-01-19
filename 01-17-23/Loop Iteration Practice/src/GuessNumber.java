import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {

        /*
         * Create a program that will generate a random number between 0 and 10 and the
         * user will guess that said number.
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 11); // create random number from 0 - 10
        System.out.println("[Guess The Number Program]");
        System.out.println("The random number is between 0 - 10 (including both numbers)");
        System.out.print("Enter your guess: "); // asks the user for their input
        int userNum = scanOne.nextInt(); // stores input in userNum

        while (userNum != randomNum) { // loop that runs while userNum is not equal to randomNum
            if (userNum > randomNum) { // if userNum is greater than randomNum
                System.out.println("Your guess is too high!");
            } else { // if userNum lower than randomNum
                System.out.println("Your guess is too low!");
            }
            System.out.print("Enter your guess: "); // asks the user to enter their guess again
            userNum = scanOne.nextInt();

        }

        // Prints messages if userNum is equal to randomNum, which breaks the while loop
        System.out.println("<><><><><><><><><><><><><><><>");
        System.out.println("You guessed the right number!");
        System.out.println("Random Number: " + randomNum);
        System.out.println("Your Number: " + userNum);
        System.out.println("<><><><><><><><><><><><><><><>");
        scanOne.close(); // closes our Scanner object

    }

}
