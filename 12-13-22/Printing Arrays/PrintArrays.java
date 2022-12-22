import java.util.Arrays;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/22/22
 * School: Universidad De Dagupan
 * Description: Printing Array Elemets
 * 
 */

public class PrintArrays {

    public static void main(String[] args) {

        /*
         * Printing array elements using a while loop, for loop, and Arrays.toString
         * method
         * 
         */

        // Creating an Array with elements to print through
        int[] numArr = { 2, 4, 6, 8, 10 };

        // While loop

        int i = 0; // will serve as our counter

        System.out.println("[While Loop]");

        System.out.print("{ ");

        while (i < numArr.length) { // while i is less than numArr length (5), run code below

            if (i != numArr.length - 1) { // if the current element is not the last, print element with comma

                System.out.print(numArr[i] + ",");
                i++; // increments i by 1

            }

            else { // if at the last element, print only the element without the comma

                System.out.print(numArr[i]);
                i++; // last increment before the while loop is broken

            }

        }

        System.out.println(" }\n"); // \n to create space before the next print statement

        // For loops

        System.out.println("[For Loop]");

        System.out.print("{ ");

        for (int j = 0; j < numArr.length; j++) {

            if (j != numArr.length - 1) { // if the current iterated element is not the last element

                System.out.print(numArr[j] + ",");

            }

            else { // if at the last element

                System.out.print(numArr[j]); // no comma

            }

        }

        System.out.println(" }\n");

        // Arrays.toString Method

        System.out.println("[Arrays.toString Method]");
        System.out.println(Arrays.toString(numArr)); // turns the array into a String and prints String

    }

}