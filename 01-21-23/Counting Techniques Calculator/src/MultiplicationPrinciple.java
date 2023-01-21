import java.math.BigInteger;

public class MultiplicationPrinciple {

    public static void main(String[] args) {

        /*
         * Multiplication Principle: Refer to Page 192 - 193 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        /*
         * A computer password consists of 26 letters of the alphabet. If a 5 letter
         * password is needed, find the probability that the password is "ABCDE."
         * Letters can be used more than once.
         * 
         */

        // In this program, we are calculating for the number of [possibilities].
        String passwordString = "ABCDE";
        int passLength = passwordString.length();
        int ALPHABET_LETTERS = 26;
        BigInteger possibilitiesNum = BigInteger.valueOf(1);

        for (int i = 0; i < passLength; i++) {
            possibilitiesNum = possibilitiesNum.multiply(BigInteger.valueOf(ALPHABET_LETTERS));
        }
        System.out.println("Number of possibilities: " + possibilitiesNum);
        System.out.println("Chance of getting \"" + passwordString + "\": 1 / " + possibilitiesNum);
    }

}
