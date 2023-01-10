import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer Lab 302
 * Program: For Loop Full Name Incrementing
 ------------------------------*/

public class PrintNameIncrement {

    public static void main(String[] args) {

        Scanner scanOne = new Scanner(System.in);
        System.out.print("Enter your name?: ");
        String fullName = scanOne.nextLine();
        System.out.print("Enter your age?: ");
        int userAge = scanOne.nextInt();
        int loopCounter = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("[" + loopCounter + "]: Hello " + fullName + " you are " + userAge + " yrs. old!");
            loopCounter++;
        }

        scanOne.close();

    }

}
