public class DoWhileLoop {

    public static void main(String[] args) {

        /*
         * Create a do while loop that runs 3 times, any message
         * 
         */

        // String as our message
        String strOne = "Do loop: ";

        // Loop amount
        int loopNum = 3;

        // Do while loop
        do {

            System.out.println(strOne + loopNum);
            loopNum--;

        } while (loopNum > 0);

    }

}