/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 16, 2023
 * Place: Home
 * Program: Do While Loop, Print Numbers
 ------------------------------*/

public class PrintNumDoWhile {

    public static void main(String[] args) {
        
        /*
         * Use the do/while loop to print i as long as i is less than 6. i is equal to 1.
         * 
         */

        int i = 1; // i variable and value
        do {
            System.out.println(i); // prints 1 to 5
            i++; // increments i
        } while (i < 6); // while i is less than 6

    }
    
}
