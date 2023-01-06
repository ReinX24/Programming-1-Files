import java.util.Scanner;

public class FactorialInput {

    public static void main(String[] args) {

        /*
         * Write a program to find the factorial value of any number entered through the
         * keyboard. 
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Factorial Calculator]");
        System.out.print("Input a number: ");
        int factNum = scanOne.nextInt();
        int factSum = 1;

        for (int i = factNum; i > 0; i--) { // for loop that decrements
            factSum = factSum * i; // 5 * 4 * 3 * 2 * 1
        }

        System.out.println("[Factorial of " + factNum + ": " + factSum + "]");
        scanOne.close(); // closes Scanner object

    }

}
