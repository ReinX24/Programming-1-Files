/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: While Loop
 ------------------------------*/

public class WhileLoop {

    public static void main(String[] args) {

        /*
         * Print numbers from 0 to 10 using a while loop through incrementing.
         * 
         */

        System.out.println("[While Loop Incrementing++]");
        int numOne = 0;
        while (numOne <= 10) {
            System.out.println(numOne); // prints numOne
            numOne++; // increments numOne
        }

        /*
         * Print numbers from 10 to 0 using a while loop through decrementing.
         * 
         */

        System.out.println("[While Loop Decrementing--]");
        int numTwo = 10;
        while (numTwo >= 0) {
            System.out.println(numTwo);
            numTwo--;
        }

    }

}
