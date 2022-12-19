public class ArrayMain {

    public static void main(String[] args) {

        /*
         * Array is a data type that can hold multiple variables. Arrays can only hold
         * one data type at a time (as far as I know) and adding data that is not the
         * same with the array type would cause and exception.
         * 
         * I may not be able to show all examples of arrays in this file.
         * 
         */

        // 2 ways of creating arrays

        // Assigning an array with space and adding objects to each position

        int[] numArrOne = new int[3]; // array that holds 3 integers
        numArrOne[0] = 3;
        numArrOne[1] = 6;
        numArrOne[2] = 9;
        // numArrOne[4] = 3; // will result in an exception since there are only spaces
        // for 3 integers in the array

        // Assigning variables directly

        int[] numArrTwo = { 1, 6, 2 };

        for (int i = 0; i < numArrTwo.length; i++) { // for loop that iterates through the array

            System.out.printf("%4d", numArrTwo[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

        // int array

        int[] myIntArr = { 1, 5, 2 };

        for (int i = 0; i < myIntArr.length; i++) { // for loop that iterates through the array

            System.out.printf("%4d", myIntArr[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

        // float array

        float[] myFloatArr = { 4.3f, 5.2f, 1.2f }; // an f at the end when we are instantiating floats

        for (int i = 0; i < myFloatArr.length; i++) { // for loop that iterates through the array

            System.out.print("   " + myFloatArr[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

        // double array

        double[] myDoubleArr = { 2.3, 5.5, 7.9 };

        for (int i = 0; i < myDoubleArr.length; i++) { // for loop that iterates through the array

            System.out.print("   " + myDoubleArr[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

        // char array

        char[] myCharArr = { 'a', 'b', 'c' };

        for (int i = 0; i < myCharArr.length; i++) { // for loop that iterates through the array

            System.out.print("   " + myCharArr[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

        // String array

        String[] myStringArr = { "Yekindar", "mONESY", "yay", "Cryo" };

        for (int i = 0; i < myStringArr.length; i++) { // for loop that iterates through the array

            System.out.print("   " + myStringArr[i]);

        }
        System.out.println("\n*************************"); // breaks print statement to new line

    }

}