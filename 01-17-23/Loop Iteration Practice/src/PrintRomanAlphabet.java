public class PrintRomanAlphabet {

    public static void main(String[] args) {

        /*
         * Print the Roman alphabet using a for loop
         * 
         */

        System.out.print("Roman Alphabet: ");
        for (char i = 'A'; i < 'Z'; i++) {
            System.out.printf("%3s", i); // prints each character in the Roman Alphabet
        }
        System.out.println();

    }

}
