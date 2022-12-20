public class RecursionMain {

    public static void main(String[] args) {

        /*
         * I saw a Python video today showing me an example of recursive functions and
         * how it compares to looping statements.
         * 
         * Think of a recursive function as a function that calls itself until it is
         * terminated by returning a false condition.
         * 
         * Video Link that I am referrring to:
         * https://www.youtube.com/watch?v=ivl5-snqul8
         * 
         * Note: I myself do not have a firm grasp when using recursion so my comments
         * may be vague or not be on point.
         * 
         */

        // Walk 10 steps

        // For Loop
        System.out.println("[For Loop]");
        walkLoop(10);

        // Recursive Function
        System.out.println("[Recursive Function]");
        walkRecur(10);

    }

    public static void walkLoop(int stepNum) {

        for (int i = 1; i <= stepNum; i++) { // starts at step 1

            System.out.println("Step : " + i); // prints step number

            // Loop will keep going until it exceeds the step number in the parameter

        }

    }

    public static void walkRecur(int stepNum) {

        if (stepNum == 0) {

            return; // terminates program

        }

        walkRecur(stepNum - 1); // the method calls itself again
        System.out.println("Step : " + stepNum); // prints step number

    }

}