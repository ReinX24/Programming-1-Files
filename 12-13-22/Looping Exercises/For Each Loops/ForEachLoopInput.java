import java.util.Scanner;

public class ForEachLoopInput {

    public static void main(String[] args) {

        /*
         * Accept 3 numbers, put numbers inside an array, and loop through each number
         * 
         */

        // Scanner to accept inputs
        Scanner scanOne = new Scanner(System.in);

        // Input first number
        System.out.print("Input #1: ");
        int numOne = scanOne.nextInt();

        // Second number
        System.out.print("Input #2: ");
        int numTwo = scanOne.nextInt();

        // Third number
        System.out.print("Input #3: ");
        int numThree = scanOne.nextInt();

        // Put all numbers in an array
        int[] numArr = { numOne, numTwo, numThree };

        // Use a for each loop to print each variable in the array
        for (int eachNum : numArr) {

            System.out.println(eachNum); // prints each variable

        }

        scanOne.close(); // closes the Scanner

    }

}
