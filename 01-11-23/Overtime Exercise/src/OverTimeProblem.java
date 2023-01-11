import java.util.Scanner;

/*---------------------------
 * Author: Rein E. Solis
 * Subject: Java Programming 01
 * PL : Java program
 * Date: January 11, 2023
 * Place: UDD Lecture Room 204
 * Program: Over Time Problem (Original)
 ------------------------------*/

public class OverTimeProblem {

    public static void main(String[] args) {

        /*
         * Problem: Create a Pseudo Code to solve the given problem. Create 3 String
         * variables and name them as myName, myAge, and myWork and set values to null,
         * then accept values for the 3 String variables. Create 6 integer variables
         * namely myRate, myOverTimeHrs, myHours, myOverTime, mySalary, and myTotal.
         * 
         * Accept values for the integer variables myRate, myOverTimeHrs, myHours
         * separately. Use myRate to multiply myHours to get mySalary. If myHours is
         * greater than or equal to 9 hours, then, use mySalary, multiply it by 30% to
         * get Overtime.
         * 
         * Use Overtime to multiply it with myOverTime to get myOverTimePay, then add
         * mySalary with myOverTime to get myTotal. Else, display "No overtime hour".
         * 
         * Display myName, myAge, myWork, mySalary, myOverTimePay, and myTotal
         * separately.
         * 
         */

        /*
         * 12/21/22
         * Recreating Overtime pseudocode given as a preliminary exam on the 1st
         * Semester of the 1st Year of A.Y. 2022 - 2023.
         * 
         * NOTE: The encoding of the pseudocode below may contain errors and such.
         * One such issue is that myOverTimePay will always result in zero because
         * we do not input any number for myOverTime other than its default assigned
         * value of 0. This may be an oversight on my part or on the test's part.
         * 
         * Further updates to be expected.
         * 
         * 01/11/22
         * This program follows the problem given in midterms exactly as how it was
         * shown in printed text during the exam. It has come to my attention and the
         * professor's attention that the written exam problem has minor differences to
         * the pseudocode that was given as the answer in checking. Thus, 2 separate
         * answers will be given due to minor differences.
         * 
         */

        // FOLLOWS ORIGINAL PROBLEM, DISREGARDS PSEUDOCODE SOLUTION

        // START

        // Set myName, myAge, and myWork as null
        String myName = null;
        String myAge = null;
        String myWork = null;

        // Set myRate, myOverTimeHrs, myHours, myOverTime, mySalary, myTotal to 0
        Double myRate = 0.0;
        Double myOverTimeHrs = 0.0; // variable not used
        Double myHours = 0.0;
        Double myOverTime = 0.0;
        Double mySalary = 0.0;
        Double myTotal = 0.0;

        // Set Overtime and OverTimePay to 0
        Double OverTime = 0.0;
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
            OverTime = mySalary * 0.3;

            // myOverTimePay is equal to Overtime multiplied by myOverTime
            myOverTimePay = OverTime * myOverTime;

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
