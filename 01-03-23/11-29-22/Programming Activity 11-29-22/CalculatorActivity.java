/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: November 11, 2022
 * Place: UDD Computer lab 302
 * Program: Basic Java Calculator
 ------------------------------*/
import java.util.Scanner;

public class CalculatorActivity {

    public static void main(String[] args) {

        Scanner scanOne = new Scanner(System.in); // Creating a Basic Java Caculator

        // Creating varibles
        float numOne;
        float numTwo;
        char mySymbol;
        float myResult = 0;

        System.out.println("--------------------------------");
        System.out.print("Enter 1st no?: ");
        numOne = scanOne.nextFloat();

        System.out.println("--------------------------------");
        System.out.print("Enter 2nd no?: ");
        numTwo = scanOne.nextFloat();

        System.out.println("--------------------------------");
        System.out.print("Enter Symbol(+,-,/,*)?: ");
        mySymbol = scanOne.next().charAt(0);

        System.out.println("--------------------------------");

        // if (mySymbol == '+') {

        //     myResult = numOne + numTwo;
        //     System.out.println("[Sum: " + myResult + "]");

        // }

        // else if (mySymbol == '-') {

        //     myResult = numOne - numTwo;
        //     System.out.println("[Difference: " + myResult + "]");

        // }

        // else if (mySymbol == 'x') {

        //     myResult = numOne * numTwo;
        //     System.out.println("[Product: " + myResult + "]");

        // }

        // else if (mySymbol == '/') {

        //     myResult = numOne / numTwo;
        //     System.out.println("[Quotient: " + myResult + "]");

        // }

        // else {

        //     System.out.println("[Don't recognize symbol]");

        // }

        // We will convert it into a switch statement

        switch(mySymbol) {

            case '+':
            myResult = numOne + numTwo;
            System.out.println("[Sum: " + myResult + "]");
            break;

            case '-':
            myResult = numOne - numTwo;
            System.out.println("[Difference: " + myResult + "]");
            break;

            case 'x':
            myResult = numOne * numTwo;
            System.out.println("[Product: " + myResult + "]");
            break;

            case '/':
            myResult = numOne * numTwo;
            System.out.println("[Product: " + myResult + "]");
            break;

            default:
            System.out.println("[Don't recognize symbol]");
            break;


        }

        scanOne.close(); // closes scanner

    }

}
