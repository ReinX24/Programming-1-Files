import java.util.Scanner;

public class InputMultiTable {

    public static void main(String[] args) {

        /*
         * Write a program that prompts the user to input a positive integer. It should
         * then print the multiplication table of that number. 
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Multiplication Table Program]");
        System.out.print("Input a  positive number: ");
        int mulNum = scanOne.nextInt(); // storing user input

        System.out.println("[Multiples of " + mulNum + "]");
        for (int i = 1; i <= 10; i++) { // only multiplies up to 10
            System.out.println(mulNum + " x " + i + " = " + mulNum * i); // multiplies mulNum by each iteration in loop
        }

        scanOne.close(); // closing our Scanner object

    }

}
