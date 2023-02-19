import java.util.Random;

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
        /* Creating an array that will have hold the sorted array */
        int[] sortedArray = new int[numArr.length];
        /*
         * Cloning the elements of numArr to sortedArray. We made a cloneArr method
         * because if we reference the numArr directly, it will also sort numArr as
         * well.
         */
        sortedArray = cloneArr(numArr, sortedArray);
        /* Sorting the array */
        sortedArray = selectionSort(sortedArray);
        /* Printing the sortedArray */
        System.out.println("[Original Array]");
        System.out.println(toStringArr(numArr));
        System.out.println("[Sorted Array]");
        System.out.println(toStringArr(sortedArray));

        /*
         * Finding the index of a number in an array using binary search, array needs to
         * be sorted first before using binary search
         */
        int indexOfSeven = binarySearch(numArr, 7);

        /* Print the index of 7 in the sortedArray */
        System.out.println("7 is located at index: " + indexOfSeven);

        /* Find the number 13 in the sortedArray */
        int indexOfThirteen = binarySearch(numArr, 13);

        /* Print the index of 13 */
        System.out.println("13 is located at index: " + indexOfThirteen); // -1 because 13 is not in sortedArray

        /* Reshuffling the order of numArr elements */
        numArr = shuffleArr(numArr);
        System.out.println("[Shuffled numArr]");
        System.out.println(toStringArr(numArr));

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

    /* Method that clones the elements of one array to another */
    public static int[] cloneArr(int[] originalArr, int[] cloneArr) {
        for (int i = 0; i < originalArr.length; i++) {
            cloneArr[i] = originalArr[i];
        }
        return cloneArr;
    }

    /* Method that sorts the array using selection sort */
    public static int[] selectionSort(int[] numArr) {
        int[] sortedArray = numArr;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    /* swaps the variables between the two indexes in the array */
                    sortedArray = swapNums(sortedArray, i, j);
                }
            }
        }
        return sortedArray;
    }

    /* Method that shuffles the elements within the array */
    public static int[] shuffleArr(int[] shuffleArr) {
        /* Random object to access Random methods */
        Random randNum = new Random();
        /* Start loop at the end of the array */
        for (int i = shuffleArr.length - 1; i > 0; i--) {
            /* Generate a number that is >= 0 && < i */
            int randomIndex = randNum.nextInt(i);
            /* Swap the places of i and randomIndex in the array */
            swapNums(shuffleArr, i, randomIndex);
        }
        /* Return shuffleArr */
        return shuffleArr;
    }

    /* Method that swaps the places of two numbers in an array */
    public static int[] swapNums(int[] swapArr, int i, int j) {
        /* Swaps the places of two numbers in an array and returns the array */
        int tempNum = swapArr[j];
        swapArr[j] = swapArr[i];
        swapArr[i] = tempNum;
        return swapArr;
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
        /* Sorts the array from lowest to highest value */
        numArr = selectionSort(numArr);
        /* Get the index of the first and last number */
        int lowIndex = 0;
        int highIndex = numArr.length - 1;
        while (lowIndex <= highIndex) {
            /* Starts at the middle of the array */
            int midIndex = (lowIndex + highIndex) / 2;
            /*
             * Checks if the number at the middle of the array is larger or smaller than
             * targetNum
             */
            int numDiff = numArr[midIndex] - targetNum;

            /* If the difference is 0, return the midIndex */
            if (numDiff == 0) {
                return midIndex;
            }
            /*
             * If the difference is less than 0, the targetNum is larger than the number at
             * midIndex
             */
            else if (numDiff < 0) {
                /* Starts the next loop at the right side of the array */
                lowIndex = midIndex + 1;
            }
            /*
             * If the difference is greater than 0, the targenNum is smaller than the number
             * at midIndex
             */
            else {
                /* Starts the next loop at the left side of the array */
                highIndex = midIndex - 1;
            }

        }
        /* If the element is not in the array, return -1 */
        return -1;
    }

}
