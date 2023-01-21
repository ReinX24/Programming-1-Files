import java.math.BigInteger;
import java.util.Scanner;

public class MultiplicationPrincipleInput {

    public static void main(String[] args) {

        /*
         * Multiplication Principle: Refer to Page 192 - 193 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        // In this program, we are calculating for the number of [possibilities].
        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Possibility Calculator - Multiplication Principle]");
        System.out.print("Input password (letters from the alphabet only): "); // asks the user for their password
        String userPassword = scanOne.nextLine();

        int passLength = userPassword.length(); // store userPassword length in passLength
        int ALPHABET_LETTERS = 26; // number of letters in the Roman Alphabet
        BigInteger bigIntPossibilities = BigInteger.valueOf(1);
        // using BigInteger since the result could have a large integer value

        for (int i = 0; i < passLength; i++) {
            bigIntPossibilities = bigIntPossibilities.multiply(BigInteger.valueOf(ALPHABET_LETTERS));
            // converts ALPHABET_LETTERS to BigInteger
        }

        // Printing probability
        System.out.println(
                "The probability of \"" + userPassword + "\" being the password is: 1 / " + bigIntPossibilities);
        scanOne.close();

    }

}
