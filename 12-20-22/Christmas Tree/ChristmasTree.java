/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/25/22
 * School: Universidad De Dagupan
 * Description: Christmas Tree
 * 
 */

public class ChristmasTree {

    public static void main(String[] args) {

        /*
         * Merry Christmas! As a way to celebrate the holidays, I will be doing an
         * exercise that will print a Christmas tree (if you can even call it that)
         * using for loops.
         * 
         */

        for (int i = 0; i < 10; i++) { // this loop will determine the height of our Christmas tree

            for (int j = 0; j < 10 - i; j++) { // prints the spaces before the stars or elements

                System.out.print(" ");

            }

            for (int k = 0; k < (2 * i - 1); k++) { // prints the starts or elements after the spaces

                System.out.print("*"); // prints asterisk for the tree

            }

            System.out.println(); // after the two inner loops are broken, print a new line and go to the next row

        }

    }

}