import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 10, 2023
 * Place: UDD Computer Lab 302
 * Program: For Loop Full Name Decrementing
 ------------------------------*/

public class PrintNameDecrement {

    public static void main(String[] args) {

        Scanner scanOne = new Scanner(System.in);
        System.out.print("Enter your name?: ");
        String fullName = scanOne.nextLine();
        System.out.print("Enter your age?: ");
        int userAge = scanOne.nextInt();

        for (int i = 10; i >= 0; i--) {
            System.out.println("[" + i + "]: Hello " + fullName + " you are " + userAge + " yrs. old!");
        }

        scanOne.close();


    }

}
