import java.util.Scanner;

public class AdditionQuiz {

    public static void main(String[] args) {

        /*
         * Create a program that will output a question regarding the sum of two
         * numbers. If the user's answer is not the sum of the two numbers, it will keep
         * asking the same question again until they get it right.
         * 
         */

        int numOne = (int) (Math.random() * 10); // creates a random number in the range of 0 - 9
        int numTwo = (int) (Math.random() * 10);

        Scanner scanOne = new Scanner(System.in); // Scanner object to accept user input

        System.out.println("What is the sum of " + numOne + " and " + numTwo + "?"); // prints question
        System.out.print("Enter answer: "); // asks for user's answer
        int userAnswer = scanOne.nextInt(); // stores user's answer in userAnswer

        while (numOne + numTwo != userAnswer) { // while loop that runs while the user's answer is incorrect
            System.out.println("Incorect Answer, Try Again"); // wrong answer message
            System.out.println("What is the sum of " + numOne + " and " + numTwo + "?"); // asks question again
            System.out.print("Enter answer: ");
            userAnswer = scanOne.nextInt();
        }

        System.out.println("Your answer is correct!"); // prints if the user answers correctly
        System.out.println(numOne + " + " + numTwo + " = " + userAnswer); // prints two number and your answer
        scanOne.close(); // closing our Scanner object

    }

}
