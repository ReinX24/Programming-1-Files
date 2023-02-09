public class CountUniqueElements {

    public static void main(String[] args) {

        /* Count the number of unique numbers within each array */
        int[] numArrOne = { 1, 1, 2 };
        System.out.println(countUniqueNums(numArrOne)); // has 2 unique elements

        int[] numArrTwo = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(countUniqueNums(numArrTwo)); // has 5 unique elements

    }

    public static int countUniqueNums(int[] nums) {
        // If the array has a length of 0, return 0
        if (nums.length == 0) {
            return 0;
        }
        // Counter that keeps track of unique numbers, 1 by default
        int uniqueNumCounter = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            // if the number at i is less than the one next to it, increment
            // uniqueNumCounter
            if (nums[i] < nums[i + 1]) {
                nums[uniqueNumCounter] = nums[i + 1];
                uniqueNumCounter++;
            }
        }
        // Return uniqueNumCounter
        return uniqueNumCounter;
    }

}