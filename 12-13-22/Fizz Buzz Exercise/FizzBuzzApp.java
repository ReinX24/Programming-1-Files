import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/15/22
 * School: Universidad De Dagupan
 * Description: Fizz Buzz Exercise
 * 
 */

public class FizzBuzzApp {

    public static void main(String[] args) {

        /*
         * Fizz Buzz is a programming exercise that tests your knowledge on loops, the
         * modulo operator, and the AND logical operator.
         * 
         * Create a loop that will loop a range of numbers. If the current iterated loop
         * is divisible by 3, print "Fizz", if divisible by 5, print "Buzz", if both,
         * print "FizzBuzz". Instead of starting from 1 then eventually end with 100, we
         * will give the user the choice to input their own number range.
         * 
         * The reason why I am sharing this exercise is because I saw an article today
         * talking about the Fizz Buzz Programming Exercise and I wanted to share it
         * here.
         * 
         * Link to aricle:
         * https://blog.codinghorror.com/why-cant-programmers-program/
         * 
         */

        // Creating a Scanner class object to accept inputs
        Scanner scanOne = new Scanner(System.in);

        // Show program title
        System.out.println("[Fizz Buzz Application]");

        // Enter initial number or first number in our loop
        System.out.print("1st Number: ");
        int numOne = scanOne.nextInt(); // instantiating our variable immediately as we input our number

        // Enter last number of our loop
        System.out.print("2nd Number: ");
        int numTwo = scanOne.nextInt();

        // For loop that will start from the first number to the second number

        for (int i = numOne; i <= numTwo; i++) { // for loop that will start from numOne and end in numTwo

            // Branching statements that will check which message will be printed

            if (i % 3 == 0 && i % 5 == 0) { // checks if i is divisible by 3 and 5

                System.out.println(i + ": FizzBuzz"); // I added the current number in our printing statement

            }

            else if (i % 3 == 0) { // if i is divisible by 3

                System.out.println(i + ": Fizz");

            }

            else if (i % 5 == 0) { // if i is divisible by 5

                System.out.println(i + ": Buzz");

            }

            else { // if not divisible by 3 or 5, print FooBar

                System.out.println(i + ": FooBar");

            }

        }

        // Closing our Scanner

        scanOne.close();

    }

}