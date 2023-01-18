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
        char myAns; // variable that loops the program as long as myAns is 'y'
        Scanner scanOne = new Scanner(System.in); // creating a Scanner object to accept input

        // Set myName, myAge, and myWork as null
        String myName = null;
        String myAge = null;
        String myWork = null;

        do {

            System.out.println("**********************************");
            System.out.println("\t[Overtime Program]");
            System.out.println("**********************************");

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

            while (myHours == 0) { // if the user input for myHours is 0
                System.out.println("**********************************");
                System.out.println("[Hours should be greater than 0]");
                System.out.print("Input hours: ");
                myHours = scanOne.nextDouble();
                /*
                 * This prompt or part where it asks the user to input a number greater than 0
                 * will keep looping until the user decides to input a number greater than 0 for
                 * myHours.
                 * 
                 */
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
                 * Instead of using myOverTime, we add myOverTimePay since that contains 30% of
                 * our salary multiplied by myOverTimeHrs instead of myOverTime which is equal
                 * to 0.
                 * 
                 */

                // myTotal = mySalary + myOverTimePay; // moved to outside of if else statement
                /*
                 * Explanation:
                 * Instead of myTotal being calculated here, we will calculate it instead after
                 * the if else statement. This is because myTotal prints 0 even if we did make
                 * money off our salary. To fix this, we moved this operation outside since
                 * mySalary should still be greater than 0 (assuming we inputted a positive
                 * number for myRate & myHours) even if myHours is not greater than or equal 9.
                 * 
                 */

            } else {
                // DISPLAY "No Overtime Hour"
                System.out.println("**********************************"); // divisor for easier readability
                System.out.println("\t[No Overtime Hour]");
            }

            System.out.println("**********************************");
            myTotal = mySalary + myOverTimePay; // moved outside of if else statement
            /*
             * myTotal outside the if else to avoid myTotal showing 0 when else statement is
             * executed and mySalary > 0
             * 
             */

            // DISPLAY myName
            System.out.printf("%-14S :  %s\n", "Name", myName);
            // DISPLAY myAge
            System.out.printf("%-14S :  %s\n", "Age", myAge);
            // DISPLAY myWork
            System.out.printf("%-14S :  %s\n", "Work", myWork);
            // DISPLAY mySalary
            System.out.printf("%-14S :  %.2f\n", "Salary", mySalary);
            // DISPLAY myOverTimePay
            System.out.printf("%-14S :  %.2f\n", "Overtime Pay", myOverTimePay);
            // DISPLAY myTotal
            System.out.printf("%-14S :  %.2f\n", "Total", myTotal);

            // Asking the user if the want to repeat the process
            System.out.println("**********************************");
            System.out.print("Enter another data set? (y/n): "); // if the user chooses Y or y, loop program again
            myAns = scanOne.next().charAt(0); // stores user input in myAns
            scanOne.nextLine(); // for terminal formatting errors

        } while (Character.toLowerCase(myAns) == 'y');
        /*
         * Character.toLowerCase(myAns) makes myAns lowecase. This is so that the
         * program keeps running even if the user accidentally inputted the capital
         * letter 'Y'. The program will make that input into lowercase and accept it as
         * 'y' and checks if that is equal to 'y' which will keep the while loop
         * running.
         * 
         */

        // STOP
        System.out.println("**********************************");
        System.out.println("[Thank you for using our program!]");
        System.out.println("**********************************");
        scanOne.close(); // closing out Scanner object after while loop
    }

}
