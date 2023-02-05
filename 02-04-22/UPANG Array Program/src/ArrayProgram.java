import java.util.Arrays;
import java.util.Scanner;

public class ArrayProgram {

    public static void main(String[] args) {

        /*
         * Solution for a Programming Activity from a friend in University of Pangasinan
         * (UPANG).
         */

        /*
         * Write a java program that uses method calling, and looping to ask the user to
         * enter 10 digits into an array. You will then duplicate the array and display
         * the result according to these parameters:
         */

        /*
         * - Sort the array from the lowest to the highest value.
         * - Sort the array 2nd lowest value first, then 2nd highest value last.
         * - Display the array without odd numbers.
         * - Display the array without even numbers.
         */

        arrayProgram(); // calling a method

    }

    public static void arrayProgram() {

        System.out.println("# Array Program");
        Scanner scanOne = new Scanner(System.in);
        int[] numArr = new int[10]; // array where the user's entered numbers will be stored
        int numSlots = numArr.length; // variable that keeps in track how many indexes in the array are not filled

        /* For loop that asks the user for 10 numbers */
        for (int i = 0; i < numArr.length; i++) {
            System.out.println("Number slots remaining: " + numSlots);
            System.out.print("Enter a number: ");
            int userNum = scanOne.nextInt();
            numArr[i] = userNum;
            numSlots--; // decrements numSlots
        }

        System.out.println("[No more number slots!]"); // prints when the for loop that asks for a number ends
        System.out.println("**********************");

        /* Duplicating the array using a for loop */
        int[] numArrDuplicate = numArr.clone(); // using the clone method to copy all elements of numArr

        /*
         * Printing numArr & numArrDuplicate (not part of instructions, for debugging)
         */
        System.out.println("# User Integer Array");
        System.out.println(Arrays.toString(numArr));
        System.out.println("# Duplicate of Integer Array");
        System.out.println(Arrays.toString(numArrDuplicate));

        /* Sort the array from lowest to highest value */
        Arrays.sort(numArr);

        /* Printing the sorted array */
        System.out.println("# Sorted Array");
        System.out.println(Arrays.toString(numArr));

        /* Sort the array 2nd lowest value first, 2nd highest value last */

        /* 2nd lowest value */
        int lowestTempNum = numArr[0]; // holds lowest value of numArr
        numArr[0] = numArr[1]; // replaces lowest value with the second lowest value
        numArr[1] = lowestTempNum; // places lowest value in the second index

        /* 2nd highest value */
        int highestTempNum = numArr[numArr.length - 1]; // holds the highest value in numArr
        numArr[numArr.length - 1] = numArr[numArr.length - 2]; // replaces highest value with the 2nd highest value
        numArr[numArr.length - 2] = highestTempNum;

        /*
         * Printing results of array with 2nd lowest value 1st & 2nd highest value last
         */
        System.out.println("# Array with 2nd lowest value 1st & 2nd highest value last");
        System.out.println(Arrays.toString(numArr));

        /* Display the array without odd numbers */
        System.out.println("# Array Without Odd Numbers");
        System.out.print("[");
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 == 0) {
                System.out.print(numArr[i] + ", ");
            }
        }
        System.out.println("]");

        /* Display the array without even numbers */
        System.out.println("# Array Without Even Numbers");
        System.out.print("[");
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 != 0) {
                System.out.print(numArr[i] + ", ");
            }
        }
        System.out.println("]");

        scanOne.close(); // closing our Scanner object

    }

}