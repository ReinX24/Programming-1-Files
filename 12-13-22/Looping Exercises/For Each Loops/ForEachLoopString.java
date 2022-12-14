import java.util.Scanner;

public class ForEachLoopString {

    public static void main(String[] args) {

        /*
         * Input 3 String, put them inside an array, iterate through them using a for
         * each loop
         * 
         */

        // Scanner to accept input
        Scanner scanOne = new Scanner(System.in);

        // Ask for the 3 Strings
        System.out.print("String #1: ");
        String strOne = scanOne.nextLine();

        System.out.print("String #2: ");
        String strTwo = scanOne.nextLine();

        System.out.print("String #3: ");
        String strThree = scanOne.nextLine();

        // Put all Strings inside an array
        String[] strArr = {strOne, strTwo, strThree};

        // Use a for each loop to iterate through our array
        for (String eachStr : strArr) {

            System.out.println(eachStr);

        }

        scanOne.close(); // closes the Scanner

    }

}
