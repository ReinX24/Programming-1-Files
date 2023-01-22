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

        System.out.println(selectionNumOne); // printing ways of selecting SELECTION_USER_NUM from the n available

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
