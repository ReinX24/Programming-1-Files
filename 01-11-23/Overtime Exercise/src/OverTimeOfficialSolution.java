import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: Over Time Problem (Pseudocode Solution)
 ------------------------------*/

public class OverTimeOfficialSolution {

    public static void main(String[] args) {

        /*
         * 1/14/23
         * Refactored to match pseudocode that was sent by the professor.
         * 
         */

        // START

        // Set myName, myAge, and myWork as null
        String myName = null;
        String myAge = null;
        String myWork = null;

        // Input myName, myAge, and myWork
        Scanner scanOne = new Scanner(System.in); // Scanner object to accept user input

        System.out.print("Input name: "); // asks for name
        myName = scanOne.nextLine();

        System.out.print("Input age: "); // asks for age
        myAge = scanOne.nextLine();

        System.out.print("Input work: "); // asks for work
        myWork = scanOne.nextLine();

        // Set myRate, myOverTimeHrs, myHours, myOverTime, mySalary, myTotal, OverTime,
        // myOverTimePay to 0
        Double myRate = 0.0;
        Double myOverTimeHrs = 0.0;
        Double myHours = 0.0;
        Double myOverTime = 0.0; // not used in the progam
        Double mySalary = 0.0;
        Double myTotal = 0.0;
        Double OverTime = 0.0;
        Double myOverTimePay = 0.0;

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
            OverTime = mySalary * 0.3;

            // myOverTimePay is equal to Overtime multiplied by myOverTimeHrs
            myOverTimePay = OverTime * myOverTimeHrs;

            // myTotal is equal to mySalary plus myOverTime
            myTotal = mySalary + myOverTime;

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

        // DISPLAY myOverTimePay
        System.out.println("Overtime: " + myOverTimePay); // results in 0?

        // DISPLAY myTotal
        System.out.println("Total: " + myTotal);

        // STOP
        scanOne.close(); // closes the Scanner

    }

}
