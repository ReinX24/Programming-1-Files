import java.math.BigInteger;
import java.util.Scanner;

public class CombinationRuleInput {

    public static void main(String[] args) {

        /*
         * Combination Rule: Refer to Page 194 of Essential Mathematics in the Modern
         * World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.print("Enter CATERGORY 1 amount: ");
        BigInteger CATERGORY_ONE = scanOne.nextBigInteger();

        System.out.print("Enter CATERGORY 2 amount: ");
        BigInteger CATEGORY_TWO = scanOne.nextBigInteger();

        System.out.print("Enter SELECTION amount: ");
        BigInteger SELECTION_USER_NUM = scanOne.nextBigInteger();

        BigInteger TOTAL_SELECTION = CATERGORY_ONE.add(CATEGORY_TWO);
        // BigInteger selectionNumOne = factorialBigInteger(n)
        // .divide(factorialBigInteger(n.subtract(SELECTION_USER_NUM).multiply(SELECTION_USER_NUM)));

        BigInteger selectionNumOne = factorialBigInteger(TOTAL_SELECTION)
                .divide(factorialBigInteger(TOTAL_SELECTION.subtract(SELECTION_USER_NUM)).multiply(SELECTION_USER_NUM));

        BigInteger selectionNumTwo = factorialBigInteger(CATERGORY_ONE).divide(
                factorialBigInteger(CATERGORY_ONE.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(1))));

        BigInteger selectionNumThree = factorialBigInteger(CATEGORY_TWO).divide(
                factorialBigInteger(CATEGORY_TWO.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(1))));

        /* Printing ways of selecting SELECTION_USER_NUM from the n available */
        System.out.printf("There are %d ways of choosing %d selections from the %d available.\n", selectionNumOne,
                SELECTION_USER_NUM, TOTAL_SELECTION);

        System.out.printf("There are %d ways of choosing %d selection from the %d available.\n", selectionNumTwo,
                1, CATERGORY_ONE);

        System.out.printf("There are %d ways of choosing %d selection from the %d available.\n", selectionNumThree,
                1, CATEGORY_TWO);

        /* Probability of one from each category was selected */
        BigInteger PROBABILITY_EACH_SELECTED = CATERGORY_ONE.multiply(CATEGORY_TWO);
        System.out.printf("The probability that one of each category was selected is: %d / %d\n", PROBABILITY_EACH_SELECTED, selectionNumOne);

        scanOne.close();

    }

    public static BigInteger factorialBigInteger(BigInteger paraBigInt) {
        if (paraBigInt.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        } else {
            return paraBigInt = paraBigInt.multiply(factorialBigInteger(paraBigInt.subtract(BigInteger.valueOf(1))));
        }
    }

}
