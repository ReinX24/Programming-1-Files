public class SequentialSearch {

    public static void main(String[] args) {

        /* Array of unsorted numbers */
        int[] numArr = { 1, 3, 5, 2, 8, 4, 6, 10, 9, 7 };

        /* Printing numArr through a method */
        System.out.println(toStringArr(numArr));

        /* Finding the index of a number using sequential search */
        int indexOfFive = sequentialSearch(numArr, 5); // finding the index of 5 in array
        System.out.println("5 is located at index: " + indexOfFive);

        /* If number is not in the array, it will return -1 */
        int indexOfTwelve = sequentialSearch(numArr, 12);
        System.out.println("12 is located at index: " + indexOfTwelve);

        /*
         * Sorting the array from lowest to highest using a sorting algorithm called
         * selection sort
         */
        int[] sortedArray = selectionSort(numArr);

        /* Printing the sortedArray */
        System.out.println(toStringArr(sortedArray));

        /*
         * Finding the index of a number in an array using binary search, array needs to
         * be sorted first before using binary search
         */
        int indexOfSeven = binarySearch(sortedArray, 7);

        /* Print the index of 7 in the sortedArray */
        System.out.println("7 is located at index: " + indexOfSeven);

        /* Find the number 13 in the sortedArray */
        int indexOfThirteen = binarySearch(sortedArray, 13);

        /* Print the index of 13 */
        System.out.println("13 is located at index: " + indexOfThirteen); // -1 because 13 is not in sortedArray

    }

    /* Method that returns a String of the Array */
    public static String toStringArr(int[] numArr) {
        String stringArr = "[ ";
        for (int i = 0; i < numArr.length; i++) {
            if (i != numArr.length - 1) {
                stringArr += numArr[i] + ", ";
            } else {
                stringArr += numArr[i] + " ]";
            }
        }
        return stringArr;
    }

    /* Method that sorts the array using selection sort */
    public static int[] selectionSort(int[] numArr) {
        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[i] > numArr[j]) {
                    /* swaps the variables between the two indexes in the array */
                    int tempNum = numArr[j];
                    numArr[j] = numArr[i];
                    numArr[i] = tempNum;
                }
            }
        }
        return numArr;
    }

    /* Method that finds the index of a certain number using sequential search. */
    public static int sequentialSearch(int[] numArr, int targetNum) {
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == targetNum) {
                return i;
            }
        }
        return -1;
    }

    /* Method that finds the index of a number using binary search */
    public static int binarySearch(int[] numArr, int targetNum) {
        /* Get the index of the first and last number */
        int lowIndex = 0;
        int highIndex = numArr.length - 1;
        while (lowIndex <= highIndex) {
            /* Starts at the middle of the array */
            int midIndex = (lowIndex + highIndex) / 2;
            int numDiff = numArr[midIndex] - targetNum;

            if (numDiff == 0) {
                return midIndex;
            }
            /* If the current number is lower than the targetNum */
            else if (numDiff < 0) {
                lowIndex = midIndex + 1;
            }
            /* If the current number is higher than the targetNum */
            else {
                highIndex = midIndex - 1;
            }

        }
        /* If the element is not in the array, return -1 */
        return -1;
    }

}
