import java.util.Scanner; // imported library for scanner

public class ScannerTest {

    public static void main(String[] args) {

        // We will now ask for an input
        Scanner scanOne = new Scanner(System.in); // scanner to accept inputs

        // instantiating variables first for this demonstration, all are integers
        int numOne = 0;
        int numTwo = 0;
        int mySum = 0;
        int myDifference = 0;
        int myProduct = 0;
        int myQuotient = 0;
        int myModulo = 0;

        System.out.println("----------------------------------"); // just for decorations
        System.out.print("Enter 1st number: "); // asks for first number
        numOne = scanOne.nextInt();

        System.out.println("----------------------------------");
        System.out.print("Enter 2nd number: "); // asks for second number
        numTwo = scanOne.nextInt();

        mySum = numOne + numTwo; // adds the two numbers and stores them in mySum
        myDifference = numOne - numTwo; // difference of the two numbers
        myProduct = numOne * numTwo; // product of the two numbers
        myQuotient = numOne / numTwo; // quotient of the two numbers
        myModulo = numOne % numTwo; // modulo of the two numbers

        System.out.println("----------------------------------");
        System.out.println("The sum is: " + mySum); // shows the sum of the two numbers
        System.out.println("The difference is: " + myDifference); // shows difference
        System.out.println("The product is: " + myProduct); // shows product
        System.out.println("The quotient is: " + myQuotient); // shows quotient
        System.out.println("The modulo is: " + myModulo); // shows module
        System.out.println("----------------------------------");

        if (mySum > 50) {

            System.out.println("[Sum is greater than 50]");
            System.out.println("[This is the true condition]");

        }

        else {

            System.out.println("[Sum is less than 50]");
            System.out.println("[This is the false condition]");

        }

        System.out.println("----------------------------------");

        scanOne.close(); // closes the scanner

        

    }

}
