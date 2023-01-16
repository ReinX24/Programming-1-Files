/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 16, 2023
 * Place: Home
 * Program: Do While Loop, Run Once
 ------------------------------*/

public class RunOnceDoWhile {

    public static void main(String[] args) {

        /*
         * Create a do while loop that prints the message "Run Once!".
         * 
         */

        int i = 5;
        do {
            System.out.println("Run Once!"); // prints once even if the while loop evaluates to false
        } while (i > 6); // will return false since 5 is not greater than 6

    }

}
