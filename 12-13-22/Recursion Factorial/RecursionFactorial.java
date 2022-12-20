public class RecursionFactorial {

    public static void main(String[] args) {

        /*
         * Find the factorial of a number using for loops and a recursive functions
         * Factorial Example:
         * 4!(4 x 3 x 2 x 1) = 24
         * 10! (10 x 9 x 8 x 7 x 6 x 5 x 4 x 3 x 2 x 1) = 3628800
         * 
         */

        // Finding the factorial of a number using a loop
        System.out.println(factorialLoop(10));

        // Finding the factorial of a number using a recursive function
        System.out.println(factorialRecursion(10));

    }

    public static int factorialLoop(int paraNum) { // function that finds the factorial of a number using a for loop

        int facNum = 1; // where we will store our result

        if (paraNum > 0) { // checks if number in parameter is greater than 0

            for (int i = 1; i <= paraNum; i++) { // loops through 1 to the number in parameter

                facNum *= (i); // 1 = 1 * current i

                /*
                 * Finding the factorial of 4
                 * 4!
                 * 1 = 1 * 1
                 * 1
                 * 1 = 1 * 2
                 * 2
                 * 2 = 2 * 3
                 * 6
                 * 6 = 6 * 4
                 * 24
                 * [Loop breaks]
                 * Factorial is 24
                 * 
                 */

            }

        }

        return facNum; // returns the factorial of the number

    }

    public static int factorialRecursion(int paraNum) { // function that finds the factorial of a number using recursion

        if (paraNum == 1) { // if the number is 1, just return the same number

            // Note: I am not sure if this is how this works
            // inside the recursive function, when the number reaches the parameter of 1, it
            // then returns the current paraNum in this iteration as the number

            return paraNum;

        }

        else {

            return paraNum * factorialRecursion(paraNum - 1);

        }

        /*
         * Find the factorial of 4
         * 4 * (4 - 1)
         * 12
         * 12 * (3 - 1)
         * 12 * 2
         * 24
         * 24 * (2 - 1)
         * 24
         * Returns 24
         * Note: I am not sure if this is how this works
         * 
         */

    }

}
