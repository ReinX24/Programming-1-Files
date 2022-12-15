import java.util.Scanner;

public class DoWhileLoopInputString {

    public static void main(String[] args) {

        /*
         * Accept an integer and a String, the integer will be the iterations that our
         * do while loop will have whereas the String will be our print message
         * 
         */

        // Scanner to accept input
        Scanner scanOne = new Scanner(System.in);

        // Input an integer that will be our number of iterations
        System.out.print("Loop Amount: ");
        int loopCount = scanOne.nextInt();
        scanOne.nextLine();
        // when asking for an integer and a String after, a bug occurs where you are not
        // able to type your desired String. To fix this, we use a nextLine method in
        // our Scanner object before moving on to the next print statement that asks for
        // out String

        // Input String that will loop inside the do while loop
        System.out.print("Loop Message: ");
        String loopMsg = scanOne.nextLine();

        // Do while loop
        do {

            System.out.println(loopMsg);
            loopCount--;

        } while (loopCount > 0);

        // Close the Scanner
        scanOne.close();
    }

}
