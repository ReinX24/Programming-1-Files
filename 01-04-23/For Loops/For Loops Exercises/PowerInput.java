import java.util.Scanner;

public class PowerInput {

    public static void main(String[] args) {

        /*
         * Two numbers are entered through the keyboard. Write a program to find the
         * value of one number raised to the power of another. (Do not use Java built-in
         * method)
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Power of a Number Calculator]");
        System.out.print("Input base: ");
        int baseNum = scanOne.nextInt();

        System.out.print("Input exponent: ");
        int expoNum = scanOne.nextInt();

        int powerResult = baseNum; // where we will store the power of our base number

        for(int i = 1; i < expoNum; i++) {
            powerResult = powerResult * baseNum;
        }

        System.out.println(baseNum + " ^ " + expoNum + " = " + powerResult);
        scanOne.close(); // closes Scanner object

    }

}
