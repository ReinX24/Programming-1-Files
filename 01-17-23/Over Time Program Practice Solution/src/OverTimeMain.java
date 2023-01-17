import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 17, 2023
 * Place: UDD Computer Lab 302
 * Program: OverTime Program
 ------------------------------*/

public class OverTimeMain {

    public static void main(String[] args) {

        // START
        char myAns = 'Y'; // variable that loops the program as long as myAns is 'Y' or 'y'
        Scanner scanOne = new Scanner(System.in);

        do {

            // Set myName, myAge, and myWork as null
            String myName = null;
            String myAge = null;
            String myWork = null;

            System.out.println("***********************************");
            System.out.println("[Overtime Program]");
            // Input myName, myAge, and myWork
            System.out.print("Input name: ");
            myName = scanOne.nextLine();

            System.out.print("Input age: ");
            myAge = scanOne.nextLine();

            System.out.print("Input work: ");
            myWork = scanOne.nextLine();

            // Set myRate, myOverTimeHrs, myHours, myOverTime, mySalary, myTotal, OverTime,
            // OverTimePay to 0
            double myRate = 0.0;
            double myOverTimeHrs = 0.0;
            double myHours = 0.0;
            // double myOverTime = 0.0; // not used in the program
            double mySalary = 0.0;
            double myTotal = 0.0;
            double OverTime = 0.0;
            // double OverTimePay = 0.0; // not used in the program

            // Added myOverTimePay for the program, not instantiated in the pseudocode
            double myOverTimePay = 0.0;

            // Input myRate
            System.out.print("Input rate: ");
            myRate = scanOne.nextDouble();

            // Input myOverTimeHrs
            System.out.print("Input overtime hours: ");
            myOverTimeHrs = scanOne.nextDouble();

            // Input myHours
            System.out.print("Input hours: "); // should not be 0
            myHours = scanOne.nextDouble();
            if (myHours == 0) { // if the user input for myHours is 0
                System.out.println("***********************************");
                System.out.println("[Hours should be greater than 0]");
                System.out.println("***********************************");
                scanOne.close(); // closing our Scanner object before terminating the program
                return; // returns to main method, terminates the program
            }

            // mySalary is equal to myRate multiplied by myHours
            mySalary = myRate * myHours;

            // If myHours is greater than or equal to 9 hours
            if (myHours >= 9) {
                // OverTime equals mySalary multiplied by 30%
                OverTime = mySalary * 0.3;
                // myOverTime pay is equal to OverTime multiplied by myOverTimeHrs
                myOverTimePay = OverTime * myOverTimeHrs;

                // myTotal is equal to mySalary plus myOverTime
                // myTotal = mySalary + myOverTime; // causes issues
                /*
                 * Instead of using myOverTime, we use myOverTimePay since that contains 30% of
                 * our salary multiplied by myOverTimeHrs instead of myOverTime which is equal
                 * to 0.
                 * 
                 */

                // myTotal = mySalary + myOverTimePay; // moved to outside of if else statement
                /*
                 * My guess to be the correct operation for this part of the program: Instead of
                 * myTotal being calculated here, we will calculate it instead after the if else
                 * statement. This is because it myTotal prints 0 even if we did make money off
                 * our salary instead of it just showing our salary.
                 * 
                 */

            } else {
                // DISPLAY "No overtime hour"
                System.out.println("***********************************"); // divisor for easier readability
                System.out.println("\t[No Overtime Hour]\t");
            }

            System.out.println("***********************************");
            myTotal = mySalary + myOverTimePay; // moved outside of if else statement
            /*
             * myTotal outside the if else to avoid myTotal showing 0 when else statement is
             * executed and mySalary > 0
             * 
             */
            // DISPLAY myName
            System.out.println("\tName\t:\t" + myName);
            // DISPLAY myAge
            System.out.println("\tAge\t:\t" + myAge);
            // DISPLAY myWork
            System.out.println("\tWork\t:\t" + myWork);
            // DISPLAY mySalary
            System.out.println("\tSalary\t:\t" + mySalary);
            // DISPLAY myOverTimePay
            System.out.println("  Overtime Pay\t:\t" + myOverTimePay);
            // DISPLAY myTotal
            System.out.println("\tTotal\t:\t" + myTotal);
            // Asking the user if the want to repeat the process
            System.out.println("***********************************");
            System.out.print("Enter another data set? (y/n): "); // if the user chooses Y or y, loop program again
            myAns = scanOne.next().charAt(0); // stores user input in myAns
            scanOne.nextLine(); // for terminal formatting errors

        } while (myAns == 'Y' || myAns == 'y');

        // STOP
        System.out.println("***********************************");
        System.out.println("[Thank you for using our program!]");
        System.out.println("***********************************");
        scanOne.close(); // closing out Scanner object after while loop
    }

}
