import java.util.Scanner;

public class AddNumbers {

    public static void main(String[] args) {

        /*
         * Write a do-while loop that asks the user to enter two numbers. The numbers
         * should be added and the sum displayed. The loop should ask the user whether
         * he or she wishes to perform the operation again. If so, the loop should
         * repeat; otherwise it should terminate. 
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        char userChoice = 'Y';
        System.out.println("[Addition Calculator]");

        do {
            System.out.print("Input 1st Number: ");
            int numOne = scanOne.nextInt();
            System.out.print("Input 2nd Number: ");
            int numTwo = scanOne.nextInt();
            int sumNum = numOne + numTwo;
            System.out.println("Sum of numbers: " + sumNum);
            System.out.print("Do you wish to repeat the operation?(y/n): ");
            userChoice = scanOne.next().charAt(0);
        } while (userChoice == 'y' || userChoice == 'Y');

        scanOne.close(); // closing our Scanner object

    }

}