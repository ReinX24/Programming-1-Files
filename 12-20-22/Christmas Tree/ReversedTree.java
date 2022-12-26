public class ReversedTree {

    public static void main(String[] args) {

        /*
         * Instead of creating a normal tree in the other files, we will be creating one
         * that is in reverse.
         * 
         */

        for (int i = 10; i > 0; i--) { // our tree will have 10 rows

            for (int j = 10; j > 0 + i; j--) { // printing spaces before each element

                System.out.print(" ");

            }

            for (int k = 0; k < (2 * i - 1); k++) { // printing the base of the tree

                System.out.print("*");

            }

            System.out.println(); // breaks into the next row

        }

    }

}