import java.math.BigInteger;

public class CombinationRule {

    public static void main(String[] args) {

        /*
         * A store has 18 different fruit juices and 16 different carbonated drinks in
         * the cooler. If two customers bought a drink each, what is the probability of
         * that one of each kind was bought?
         * 
         */

        /* Formula: nPr = n! / (n - r)! r! */
        BigInteger nOne = BigInteger.valueOf(34);
        BigInteger rOne = BigInteger.valueOf(2);

        /* Selecting 2 Drinks from the 34 Available */
        BigInteger waysNumOne = factorialNum(nOne)
                .divide(factorialNum(nOne.subtract(rOne)).multiply(factorialNum(rOne)));
        System.out.printf("There are %d ways of selecting %d drinks from the %d available.\n", waysNumOne, rOne, nOne);

        /* Selecting 1 Fruit Juice from 18 Available */
        BigInteger nTwo = BigInteger.valueOf(18);
        BigInteger rTwo = BigInteger.valueOf(1);
        BigInteger waysNumTwo = factorialNum(nTwo)
                .divide(factorialNum(nTwo.subtract(rTwo)).multiply(factorialNum(rTwo)));
        System.out.printf("There are %d ways of selecting %d fruit juice from the %d available.\n", waysNumTwo, rTwo,
                nTwo);

        /* Selecting 1 Carbonated Drink from 16 Available */
        BigInteger nThree = BigInteger.valueOf(16);
        BigInteger rThree = BigInteger.valueOf(1);
        BigInteger waysNumThree = factorialNum(nThree)
                .divide(factorialNum(nThree.subtract(rThree)).multiply(factorialNum(rThree)));
        System.out.printf("There are %d ways of selecting %d carbonated drink from the %d available.\n", waysNumThree,
                rThree,
                nThree);

    }

    /*
     * Method that finds the factorial of a number using BigIntegers and Recursion
     */
    public static BigInteger factorialNum(BigInteger paraBigNum) {
        if (paraBigNum.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        } else {
            return paraBigNum = paraBigNum.multiply(factorialNum(paraBigNum.subtract(BigInteger.valueOf(1))));
        }
    }

}
