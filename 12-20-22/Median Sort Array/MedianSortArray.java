import java.util.Arrays;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/11/22
 * School: Universidad De Dagupan
 * Description: Median of an Array
 * 
 */

public class MedianSortArray {
    public static void main(String[] args) {

        /*
         * I searched for a leetcode question for arrays and I found this one since I
         * found it interesting. If you want to try solving this yourself, I recommend
         * clicking the link below and try to do the leetcode problem on your own.
         * 
         * NOTE: My solution is only one of many and there are many more out there that
         * are probably shorter, faster, and uses less memory.
         * 
         * Link:
         * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
         * 
         */

        int[] arrOne = { 1, 3 };
        int[] arrTwo = { 2 };
        double oddMedian = findMedianSortedArrays(arrOne, arrTwo);
        System.out.println("Median #1: " + oddMedian);

        int[] arrThree = { 1, 3 };
        int[] arrFour = { 4, 2 };
        double evenMedian = findMedianSortedArrays(arrThree, arrFour);
        System.out.println("Median #2: " + evenMedian);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int arrOneLen = nums1.length; // length of first array
        int arrTwoLen = nums2.length; // length of second array
        int[] mergedArrays = new int[arrOneLen + arrTwoLen];
        // creates a new array that has the length of the two first arrays

        for (int i = 0; i < arrOneLen; i++) { // loop that will add numbers to the new array

            mergedArrays[i] = nums1[i]; // adds numbers from first array

        }

        // After adding first array, we will now add the second array
        for (int i = 0; i < arrTwoLen; i++) { // starts from last position in last array

            mergedArrays[arrOneLen] = nums2[i]; // adds numbers from second array
            arrOneLen++; // goes to the next position

        }

        Arrays.sort(mergedArrays); // sorts the arrays in increasing order
        System.out.println(Arrays.toString(mergedArrays)); // prints sorted array before finding median

        if (mergedArrays.length % 2 == 0) { // if array length has even numbers

            double medOne = mergedArrays[mergedArrays.length / 2];
            double medTwo = mergedArrays[((mergedArrays.length / 2) - 1)];
            double medEven = (medOne + medTwo) / 2; // adds and divides the two numbers, result is the median
            return medEven; // return median

        }

        else { // if array length is an odd number

            int medOdd = mergedArrays[((mergedArrays.length + 1) / 2) - 1]; // goes to the center of the array
            return medOdd; // returns median

        }

    }

}