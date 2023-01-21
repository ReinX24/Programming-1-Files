import java.math.BigInteger;
import java.util.Scanner;

public class PermutationRuleInput {

    public static void main(String[] args) {

        /*
         * Permutation Rule: Refer to Page 193 of Essential Mathematics in the Modern
         * World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Possibility Calculator - Permutation Rule]");
        System.out.print("Input password (letters from the alphabet only): "); // asks the user for their password
        String userPassword = scanOne.nextLine();

        BigInteger passLength = BigInteger.valueOf(userPassword.length());
        BigInteger ALPHABET_LETTERS = BigInteger.valueOf(26);

        /* Formula for Permutation Rule: n! / (n - r)! */
        BigInteger possibleArrangements = (factorialNum(ALPHABET_LETTERS)
                .divide(factorialNum(ALPHABET_LETTERS.subtract(passLength))));
        // using BigInteger since the result is a large number

        /* Printing Results */
        System.out.println("There are " + possibleArrangements + " possible ordered arrangements.");
        System.out.println(
                "The probability of \"" + userPassword + "\" being the password is: 1 / " + possibleArrangements);

        scanOne.close();

    }

    /* Method that finds the factorial of a number through recursion */
    public static BigInteger factorialNum(BigInteger paraNum) {
        if (paraNum.equals(BigInteger.valueOf(0))) { // base case
            return BigInteger.valueOf(1);
        } else { // bigIntParam = bigIntParam * factorialNum(paraNum - 1)
            return paraNum = paraNum.multiply(factorialNum(paraNum.subtract(BigInteger.valueOf(1))));
        }
    }

}