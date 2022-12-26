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
        System.out.println("> Recommended tree height is 10");
        System.out.print("Enter height of tree: ");

        if (!scanOne.hasNextInt()) { // checks if the user input is an integer

            System.out.println("[Input not an Integer]");
            scanOne.close(); // closes the Scanner
            return; // returns to main method and terminates the program

        }

        int treeHeight = scanOne.nextInt();

        int treeTrunk = 0;

        if (treeHeight >= 10) { // if the tree height is 10 or more, add a trunk underneath

            for (int i = 0; i <= treeHeight; i++) { // for loop that goes from 0 to treeHeight number

                if (i % 10 == 0) { // for every 10 rows, reserve 3 trunks for the tree

                    treeHeight -= 3; // decreases treeHeight by 3 to be used as tree trunk
                    treeTrunk += 3; // adds 3 to trunk size of the Christmas tree

                }

            }

        }

        // Outer for loop
        for (int i = 0; i < treeHeight; i++) { // will dictate the amount of rows of the program

            // First inner loop
            for (int j = 0; j < treeHeight - i; j++) { // loop that prints spaces before elements in each row

                System.out.print(" ");

            }

            // Second inner loop
            for (int k = 0; k < (2 * i + 1); k++) { // for loop that prints the tree

                if ((2 * i + 1) == 1) { // if the row is at the start, print the asterisk as the star

                    System.out.print("*");

                }

                else { // if at the bottom of the star

                    System.out.print("^");

                }

            }

            System.out.println(); // break into a new line after the row is done printing

        }

        // After the for loop ended, we print the tree's trunks
        for (int i = 0; i < treeTrunk; i++) {

            for (int j = 0; j < treeHeight; j++) { // loop that prints spaces before elements in each row

                System.out.print(" ");

            }

            System.out.println("#"); // symbol that will serve as our trunk

        }

        scanOne.close(); // closes the Scanner

    }

}
