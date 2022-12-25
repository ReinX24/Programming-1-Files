import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/25/22
 * School: Universidad De Dagupan
 * Description: User Christmas Tree Program
 * 
 */

public class UserChristmasTree {

    public static void main(String[] args) {

        /*
         * This is a program where the user can dictate the height and width of the
         * Christmas tree.
         * 
         */

        Scanner scanOne = new Scanner(System.in); // Scanner object to accept input

        System.out.println("[Christmas Tree Program]");
        System.out.println("> Tree Height must be >= 10");
        System.out.print("Enter height of tree: ");
        int treeHeight = scanOne.nextInt();

        int treeTrunk = 0;

        if (treeHeight >= 10) {

            for (int i = 0; i <= treeHeight; i++) {

                if (i % 10 == 0) {

                    // We will save 3 spaces below to be our tree's trunk

                    treeHeight -= 3; // decreases treeHeight by 3 to be used as tree trunk
                    treeTrunk += 3; // adds 3 to trunk size of the Christmas tree

                }

            }

        }

        for (int i = 0; i < treeHeight; i++) { // will dictate the amount of rows of the program

            for (int j = 0; j < treeHeight - i; j++) { // loop that prints spaces before elements in each row

                System.out.print(" ");

            }

            for (int k = 0; k < (2 * i + 1); k++) {

                if ((2 * i + 1) == 1) { // if the row is at the start

                    System.out.print("*");

                }

                else { // if at the base of thee tree

                    System.out.print("^");

                }

            }

            System.out.println();

        }

        // After the for loop ended, we print the tree's trunks

        for (int i = 0; i < treeTrunk; i++) {

            for (int j = 0; j < treeHeight; j++) { // loop that prints spaces before elements in each row

                System.out.print(" ");

            }

            System.out.println("#");

        }

        scanOne.close(); // closes the Scanner

    }

}
