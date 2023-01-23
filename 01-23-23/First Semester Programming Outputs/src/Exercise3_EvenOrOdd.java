import java.util.Scanner;

public class Exercise3_EvenOrOdd {

    public static void main(String[] args) {

        /*
         * Input a number and check if it is even or odd
         * Input: int a
         * Output: "is even" or "is odd"
         */

        /* Scanner object to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Asking for a number */
        System.out.print("Enter a number: ");
        int a = scanOne.nextInt();
        /* Checking if the number is odd or even */
        if (a % 2 == 0) { // divides the number by 2 and checks if the remainder is 0, modulo operator
            System.out.println(a + " is even");
        } else {
            System.out.println(a + " is odd");
        }
        /* Closing our Scanner object */
        scanOne.close();

    }

}
