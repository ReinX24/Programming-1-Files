public class MedianSortedArray {

    public static void main(String[] args) {

        /*
         * Given two sorted arrays, nums1 and nums2 of size m and n respectively, return
         * the median of the two sorted arrays.
         * 
         * Input: {1, 2, 3}, {4, 5}
         * Expected output: 3
         */

        /* Examples of finding medians in one array */
        int[] medianExampleOne = { 1, 3, 3, 6, 7, 8, 9 };
        printArray(medianExampleOne);
        System.out.println("Median: " + medianOfArray(medianExampleOne, medianExampleOne.length));

        int[] medianExampleTwo = { 1, 2, 3, 4, 5, 6, 8, 9 };
        printArray(medianExampleTwo);
        System.out.println("Median: " + medianOfArray(medianExampleTwo, medianExampleTwo.length));

        /* Median of 2 sorted arrays */
        /* 2 arrays and their lengths */
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 4, 5 };
        int m = nums1.length;
        int n = nums2.length;

        /* Merging the arrays using methods */
        int[] combinedNumsArr = new int[m + n]; // creating an array that will store the merged arrays
        combinedNumsArr = mergeArrays(nums1, nums2);
        printArray(combinedNumsArr);
        System.out.println("Median: " + medianOfArray(combinedNumsArr, m + n));

    }

    /*
     * Creating a method that takes an integer array and its size and returns the
     * median of the array
     */
    public static float medianOfArray(int[] numArr, int numArrLength) {
        /* if the array has an odd number of elements */
        if (numArrLength % 2 != 0) {
            return numArr[numArrLength / 2];
        }
        /* if the array has an even number of elements */
        return (float) (numArr[numArrLength / 2] + numArr[numArrLength / 2 - 1]) / 2;
    }

    /* Method that prints an array */
    public static void printArray(int[] numArr) {
        String convertedArrayString = "[";
        for (int i = 0; i < numArr.length; i++) {
            if (i != numArr.length - 1) {
                convertedArrayString += numArr[i] + ", ";
            } else {
                convertedArrayString += numArr[i];
            }
        }
        convertedArrayString += "]";
        System.out.println(convertedArrayString);
    }

    /* Method that merges 2 arrays and returns an array */
    public static int[] mergeArrays(int[] numArrOne, int[] numArrTwo) {
        /* Array that stoes the two arrays combined */
        int[] mergedArr = new int[numArrOne.length + numArrTwo.length];
        /* Adding numArrOne to mergedArr */
        for (int i = 0; i < numArrOne.length; i++) {
            mergedArr[i] = numArrOne[i];
        }
        /* Adding numArrTwo to mergedArr */
        for (int i = numArrOne.length; i < mergedArr.length; i++) {
            mergedArr[i] = numArrTwo[i - numArrOne.length];
        }
        /* Returning mergedArr */
        return mergedArr;
    }

}