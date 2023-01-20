public class BlastOffWhileLoop {

    public static void main(String[] args) {

        /*
         * Print the message
         * 3
         * 2
         * 1
         * Blast Off!
         * in the terminal using a while loop
         * 
         */

        int startNum = 3; // startin number
        while (startNum > 0) { // while startNum is greater than 0
            System.out.println(startNum); // prints startNum
            startNum--; // decrements startNum
        }
        System.out.println("Blast Off!"); // prints when while loop is broken

    }

}
