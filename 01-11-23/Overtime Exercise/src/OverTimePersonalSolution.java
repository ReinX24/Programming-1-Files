import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: Over Time Problem (Personal Solution)
 ------------------------------*/

public class OverTimePersonalSolution {

    public static void main(String[] args) {

        /*
         * Refactored version of OvertimeApp, this somewhat strays away from the original
         * functions of the code but the idea will still stay the same.
         * 
         */

        // START

        // Set myName, myAge, and myWork as null
        String myName = null;
        String myAge = null;
        String myWork = null;

        // Set myRate, myOverTimeHrs, myHours, myOverTime, mySalary, myTotal to 0
        Double myRate = 0.0;
        Double myOverTimeHrs = 0.0;
        Double myHours = 0.0;
        // Double myOverTime = 0.0; // not used in the progam in my version
        Double mySalary = 0.0;
        Double myTotal = 0.0;

        // Set Overtime and OverTimePay to 0
        Double Overtime = 0.0;
        Double myOverTimePay = 0.0;

        // Input myName, myAge, and myWork
        Scanner scanOne = new Scanner(System.in); // Scanner object to accept user input

        System.out.print("Input name: "); // asks for name
        myName = scanOne.nextLine();

        System.out.print("Input age: "); // asks for age
        myAge = scanOne.nextLine();

        System.out.print("Input work: "); // asks for work
        myWork = scanOne.nextLine();

        // Input myRate
        System.out.print("Input rate: ");
        myRate = scanOne.nextDouble();

        // Input myOverTimeHrs
        System.out.print("Input overtime hours: ");
        myOverTimeHrs = scanOne.nextDouble();

        // Input myHours
        System.out.print("Input normal hours: ");
        myHours = scanOne.nextDouble();

        // mySalary is equal to myRate multiplied by myHours
        mySalary = myRate * myHours;

        // If myHours is greater than or equal to 9 hours
        if (myHours >= 9) {

            // Overtime equals mySalary multiplied by 30%
            Overtime = mySalary * 0.3;

            // myOverTimePay is equal to Overtime multiplied by myOverTime
            // myOverTimePay = Overtime * myOverTime;

            /*
             * In the original pseudocode, we multiply Overtime by myOverTime,
             * but from my observation, we do not instantiate a value of myOverTime
             * other than its default value of 0. So in OvertimeApp, myOverTimePay
             * will always result to 0 regardless of our inputs.
             * 
             * To fix this, in this version of the program we will be multiplying Overtime
             * by myOverTimeHrs instead since that is my best guess to the correct variable
             * that should be in place of myOverTime.
             * 
             * My rationale for this is that myOverTimePay is equal to 30% of our original
             * salary multiplied by our overtime hours or myOverTimeHrs.
             * 
             */

            // myOverTimePay is equal to Overtime multiplied by myOverTimeHrs
            myOverTimePay = Overtime * myOverTimeHrs;

            // myTotal is equal to mySalary plus myOverTime
            // myTotal = mySalary + myOverTime;

            /*
             * We will replace myOverTime with myOverTimePay since my guess is that variable
             * should replace myOverTime. This is because adding mySalary to myOverTime
             * would not make any difference in myTotal.
             * 
             * My reasoning for this is that myTotal is equal to our salary or mySalary plus
             * the computed overtime pay in the last computation (see code above).
             * 
             */

            // myTotal is equal to mySalary plus myOverTime
            myTotal = mySalary + myOverTimePay;

        }

        // Else
        else {

            // Display "No Overtime Hour"
            System.out.println("No Overtime Hour");

        }

        // DISPLAY myName
        System.out.println("Name: " + myName);

        // DISPLAY myAge
        System.out.println("Age: " + myAge);

        // DISPLAY myWork
        System.out.println("Work: " + myWork);

        // DISPLAY mySalary
        System.out.println("Salary: " + mySalary);

        // DISPLAY myOverTimeHrs (NOT PART OF ORIGINAL PROGRAM)
        System.out.println("Overtime hours: " + myOverTimeHrs);

        // DISPLAY myOverTimePay
        System.out.println("Overtime pay: " + myOverTimePay);

        // DISPLAY myTotal
        System.out.println("Total: " + myTotal);

        // STOP
        scanOne.close(); // closes the Scanner

    }

}
