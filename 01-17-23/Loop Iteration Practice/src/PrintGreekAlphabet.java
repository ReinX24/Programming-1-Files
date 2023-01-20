public class PrintGreekAlphabet {

    public static void main(String[] args) {

        /*
         * Print the Greek alphabet using a for loop
         * 
         */

        System.out.print("Greek Alphabet: ");
        for (int i = 913; i < 937; i++) {
            System.out.printf("%3s", (char) i); // converts the number into a char (Unicode)
        }
        System.out.println();

    }

}
