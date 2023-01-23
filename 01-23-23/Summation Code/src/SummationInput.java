import java.util.Scanner;

public class SummationInput {

    public static void main(String[] args) {

        /* Scanner to accept user input */
        Scanner scanOne = new Scanner(System.in);
        /* Ask for initial number */
        System.out.print("Enter initial number: ");
        int INIT_NUM = scanOne.nextInt();
        /* Ask for final number */
        System.out.print("Enter final number: ");
        int FINAL_NUM = scanOne.nextInt();
        /* Print result of initial and final number */
        System.out.println("x1 = 3(1) + 2 = " + (3 * (INIT_NUM) + 2));
        System.out.println("x50 = 3(50) + 2 = " + (3 * (FINAL_NUM) + 2));
        /* Calculate & print summation of all numbers */
        int summationResult = FINAL_NUM * ((3 * (INIT_NUM) + 2) + (3 * (FINAL_NUM) + 2)) / 2;
        System.out.println("Summation Result: " + summationResult);
        /* Closing our Scanner object */
        scanOne.close();

    }

}
