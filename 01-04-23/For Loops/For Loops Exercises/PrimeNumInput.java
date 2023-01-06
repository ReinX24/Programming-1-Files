import java.util.Scanner;

public class PrimeNumInput {

    public static void main(String[] args) {

        /*
         * Write a program that prompts the user to input a positive integer. It should
         * then output a message indicating whether the number is a prime number. 
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Prime Number Program]");
        System.out.println("> Checks if the number is a prime number or not.");
        System.out.print("Input number: ");
        int userNum = scanOne.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < userNum; i++) { // checks if number is divisible by 1 and the userNum (exclusive)
            if (userNum % 2 == 0) { // if it is divisible by one of these numbers, it is not a prime number
                isPrime = false;
            }
        }

        if (isPrime && userNum > 1) {
            System.out.println(userNum + " is a Prime Number!");
        } else {
            System.out.println(userNum + " is NOT a Prime Number.");
        }

        scanOne.close(); // closes our Scanner object

    }

}
