/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: Do While Loop
 ------------------------------*/

public class DoWhileLoop {

    public static void main(String[] args) {
        
        /*
         * Print numbers 0 to 10 using a do while loop (incrementing).
         * 
         */

        System.out.println("[Do While Loop Incrementing++]");
        int numOne = 0;
        do {
            System.out.println(numOne); // prints numOne
            numOne++; // increments numOne
        } while (numOne <= 10);

               
        /*
         * Print numbers 0 to 10 using a do while loop (incrementing).
         * 
         */

        System.out.println("[Do While Loop Decrementing--]");
        int numTwo = 10;
        do {
            System.out.println(numTwo);
            numTwo--;
        } while (numTwo >= 0);

    }
    
}
