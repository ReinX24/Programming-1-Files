import java.math.BigInteger;

public class PermutationRule {

    public static void main(String[] args) {

        /*
         * Permutation Rule: Refer to Page 193 of Essential Mathematics in the Modern
         * World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        /*
         * Find the probability that the password is "ABCDE" if letters cannot be
         * repeated.
         * 
         */

        // In this program, we are calculating for the number of [arrangements].

        String passWord = "ABCDE";
        BigInteger r = BigInteger.valueOf(passWord.length());
        BigInteger n = BigInteger.valueOf(26);

        /* Formula for Permutation Rule: n! / (n - r)! */
        BigInteger possibleArrangements = (factorialNum(n).divide(factorialNum(n.subtract(r))));
        // using BigInteger since the result is a large number

        /* Printing Results */
        System.out.println("There are " + possibleArrangements + " such ordered arrangements.");
        System.out.println("Hence, the probability required is: 1 / " + possibleArrangements);

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
