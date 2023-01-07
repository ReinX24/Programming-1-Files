import java.util.Scanner;

public class HighestCommonFactor {

    public static void main(String[] args) {

        /*
         * Write a program to calculate the HCF of Two given numbers.
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Highest Common Factor Calculator]");
        System.out.print("Input 1st Number: ");
        int numOne = scanOne.nextInt();
        System.out.print("Input 2nd Number: ");
        int numTwo = scanOne.nextInt();

        int maxLoop = 0; // storing maximum amount of loops
        int highestCommonFactor = 0; // storing HCF

        if (numOne < numTwo) { // sets maxNum
            maxLoop = numOne;
        } else {
            maxLoop = numTwo;
        }

        for (int i = 1; i <= maxLoop; i++) {
            if (numOne % i == 0 && numTwo % i == 0) { // checks if both are
                highestCommonFactor = i; // sets current index as HCF
            }
        }

        // Printing results
        System.out.println("Highest Common Factor of " + numOne + " & " + numTwo + " is [" + highestCommonFactor + "]");
        scanOne.close(); // closing our Scanner object

    }

}