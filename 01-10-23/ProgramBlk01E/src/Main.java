import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer Lab 302
 * Program: Multiplication Table
 ------------------------------*/

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         * Multiplication Table
         * Multiplier * Multiplicant = Product
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.print("Enter multiplicand: ");
        int multiplicantNum = scanOne.nextInt();

        System.out.println("[Multiplication Table of " + multiplicantNum + "]");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + ". " + i + " * " + multiplicantNum + " = " + i * multiplicantNum);
        }

        scanOne.close(); // closing our Scanner object

    }
}
