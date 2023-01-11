/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: Do Loop
 ------------------------------*/

public class DoLoop {

    public static void main(String[] args) {

        System.out.println("[Do Loop]");
        int numOne = 0;
        do {
            System.out.println(numOne); // prints numOne (0)
            numOne++;
            if (numOne >= 0) {
                System.out.println(numOne); // prints numOne (1)
            } else {
                return; // terminates program, does not work if return 0;
            }
        } while (false); // does not run if there is no while condition at the end

        /*
         * Even if the while condition is false, the program at least runs once, this is
         * because the nature of the do while loop is that it will run once regardless
         * if the while loop condition is false.
         * 
         */

    }

}
