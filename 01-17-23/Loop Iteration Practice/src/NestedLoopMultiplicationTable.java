public class NestedLoopMultiplicationTable {

    public static void main(String[] args) {

        /*
         * Create a multiplication table using nested for loops (multiplicand &
         * multiplier from 1 - 10).
         * 
         */

        for (int i = 1; i <= 10; i++) { // loops multipliers
            for (int j = 1; j <= 10; j++) { // loops multiplicands
                System.out.printf("%4d", i * j); // prints products using printf
            }
            System.out.println(); // breaks into new line after priting a row
        }

    }

}
