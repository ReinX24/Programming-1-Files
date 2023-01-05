public class MultiplesOfNum {

    public static void main(String[] args) {

        /*
         * Printing all the multiples of 1 to 10 (1 * 1, 1 * 2, - 1 * 10 to 10 * 1, 10 *
         * 2, - 10 * 10)
         * 
         */

        for (int i = 1; i <= 10; i++) { // multiplier
            System.out.println("Multiples of " + i + ":");
            for (int j = 1; j <= 10; j++) { // multiplicand
                System.out.printf("%4d", j * i); // prints 4 spaces before the product
            }
            System.out.println(); // breaks to a new line
        }

    }

}
