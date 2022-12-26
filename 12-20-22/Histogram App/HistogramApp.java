import java.util.Random;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/26/22
 * School: Universidad De Dagupan
 * Description: Histogram Application
 * 
 */

public class HistogramApp {

    public static void main(String[] args) {

        /*
         * Create a Histogram progam that finds the amount of numbers that are within
         * the conditions of a range.
         * 
         * Note: Contains advanced topics not yet covered in Programming 1.
         * 
         */

        // Creating an array with random numbers
        int[] arrOne = randomArray(10); // array will have 10 elements
        printArray(arrOne); // prints the array
        int upHalf = inRange(arrOne, 50, 100); // counts numbers in array that are >= 50 but < 100
        System.out.println("Numbers >= 50 & < 100: " + upHalf);
        int downHalf = inRange(arrOne, 0, 50); // counts numbers that are >= 0 but < 50
        System.out.println("Numbers >= 0 & < 50: " + downHalf);

        // Find the amount of instances of each number in the array

        int[] numIndex = new int[100]; // array that has 100 elements, index starts at 0 & ends at 99

        for (int i = 0; i < arrOne.length; i++) { // looping through our array

            int indexNum = arrOne[i]; // assigns indexNum to current iterated number
            numIndex[indexNum]++; // increments the corresponding index position in numIndex

            /*
             * If the loop has, for example, two 10s in the array, these will increment the
             * index of 10 in the array two times. So if we print that array index position,
             * it will print 2.
             * 
             */

        }

        printArray(numIndex);
        System.out.println("Counts of 10: " + numIndex[10]); // prints how many instances of 10 are in the array
        System.out.println("Counts of 30: " + numIndex[30]);
        System.out.println("Counts of 50: " + numIndex[50]);
        System.out.println("Counts of 70: " + numIndex[70]);

    }

    // Method that checks if the array has certain numbers in range
    public static int inRange(int[] numArr, int numMin, int numMax) {

        int numCount = 0; // counter for how many numbers are in that range

        for (int i = 0; i < numArr.length; i++) {

            if (numArr[i] >= numMin && numArr[i] < numMax) {
                // if the current iterated number is >= numMin & < numMax

                numCount++; // increment numCount

            }

        }

        return numCount; // returns numCount

    }

    // Method that returns an array with random numbers
    public static int[] randomArray(int arrSize) { // returns a random array

        Random ranOne = new Random(); // object of the Random class, for accessing random methods
        int[] ranArr = new int[arrSize]; // array that will hold our random numbers

        for (int i = 0; i < arrSize; i++) {

            ranArr[i] = ranOne.nextInt(100); // assigns a number >= 0 but < 100

        }

        return ranArr;

    }

    // Method that prints the array
    public static void printArray(int[] numArr) { // takes an array as a parameter

        System.out.print("{ ");
        for (int i = 0; i < numArr.length; i++) {

            if (i == numArr.length - 1) { // if the loop is at the final element, print closing bracket

                System.out.println(numArr[i] + " }");

            }

            else { // prints comma after each element

                System.out.print(numArr[i] + ",");

            }

        }

    }

}