import java.util.Scanner;

public class OvertimeApp {

    public static void main(String[] args) {

        /*
         * 12/21/22
         * Recreating Overtime pseudocode given as a preliminary exam on the 1st
         * Semester of the 1st Year of A.Y. 2022 - 2023.
         * 
         * NOTE: The encoding of the pseudocode below may contain errors and such.
         * One such issue is that myOverTimePay will always result in zero because
         * we do not input any number other than 0 for Overtime. This may be an
         * oversight on my part or on the test's part.
         * 
         * Further updates to be expected.
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
        Double myOverTime = 0.0;
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
        System.out.print("Input hours: ");
        myHours = scanOne.nextDouble();

        // mySalary is equal to myRate multiplied by myHours
        mySalary = myRate * myHours;

        // If myHours is greater than or equal to 9 hours
        if (myHours >= 9) {

            // Overtime equals mySalary multiplied by 30%
            Overtime = mySalary * 0.3;

            // myOverTimePay is equal to Overtime multiplied by myOverTime
            myOverTimePay = Overtime * myOverTime;

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