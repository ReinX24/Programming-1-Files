import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 01/04/23
 * School: Universidad De Dagupan
 * Description: Basic Calculator Using Switch Case Statement
 * 
 */

public class BasicCalculatorSwitch {

    public static void main(String[] args) {

        Scanner scanOne = new Scanner(System.in); // Scanner object to accept user input

        int numOne; // first number
        int numTwo; // second number
        char myOperator; // operator
        int myResult; // result

        System.out.print("Input 1st Number: ");
        numOne = scanOne.nextInt();

        System.out.print("Input 2nd Number: ");
        numTwo = scanOne.nextInt();

        System.out.print("Input Operator (+ - / * %): ");
        myOperator = scanOne.next().charAt(0); // no charNext, so we do the following to get our character

        switch (myOperator) {
            case '+':
                myResult = numOne + numTwo;
                System.out.println("Sum of two numbers: " + myResult);
                break;
            case '-':
                myResult = numOne - numTwo;
                System.out.println("Difference of two numbers: " + myResult);
                break;
            case '/':
                myResult = numOne / numTwo;
                System.out.println("Quotient of the two numbers: " + myResult);
                break;
            case '*':
                myResult = numOne * numTwo;
                System.out.println("Product of the two numbers: " + myResult);
                break;
            case '%':
                myResult = numOne % numTwo;
                System.out.println("Remainder of the two numbers: " + myResult);
                break;
            default:
                System.out.println("Unknown Operator");
                break;
        }
        scanOne.close(); // closes the Scanner object
    }

}