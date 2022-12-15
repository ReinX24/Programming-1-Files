import java.util.Scanner;

public class DoWhileLoopInput {

    public static void main(String[] args) {

        /*
         * Accept an integer, integer will be the amount of times the do while loop
         * loops
         * 
         */

        // Scanner to accept input
        Scanner scanOne = new Scanner(System.in);

        // Input an integer
        System.out.print("Loop Amount: ");
        int loopCount = scanOne.nextInt();

        // String that will loop inside the do while loop
        String loopMsg = "Loop #: ";

        // Do while loop
        do {

            System.out.println(loopMsg + loopCount);
            loopCount--;

        } while (loopCount > 0);

        // Close the Scanner
        scanOne.close();
    }

}
