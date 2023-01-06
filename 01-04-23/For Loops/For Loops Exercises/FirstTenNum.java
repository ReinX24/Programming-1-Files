public class FirstTenNum {

    public static void main(String[] args) {

        /*
         * Write a program to calculate the sum of first 10 natural number.
         * 
         */

        int sumNum = 0; // where we will store the sum of the numbers
        for (int i = 1; i <= 10; i++) { // loops from 1 to 10
            sumNum = sumNum + i; // we add the current i to sumNum
            // 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
        }

        System.out.println("Sum of the first 10 natural numbers: " + sumNum);

    }

}
