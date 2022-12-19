public class IteratingArrays {

    public static void main(String[] args) {

        /*
         * Iterating through arrays using loops
         * 
         */

        int[] numArr = { 1, 7, 2, 4, 76, 2, 4 };

        // iterating through an array using a for loop

        System.out.println("[For Loop]");

        for (int i = 0; i < numArr.length; i++) { // for loop

            System.out.println(numArr[i]);

        }

        System.out.println("[For Each Loop]");

        for (int eachNum : numArr) { // for each loop

            System.out.println(eachNum);

        }

    }

}
