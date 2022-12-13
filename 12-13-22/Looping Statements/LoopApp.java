/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/13/22
 * School: Universidad De Dagupan
 * Description: Looping or Iterating Statements
 * 
 */

class LoopApp {

    public static void main(String[] args) {

        /*
         * 12/13/22
         * As of the writing of this note, the topic of looping or iterating statements
         * has not been taught yet in our Programming 1 class. But as some sort of an
         * advanced reading or studying for the topic, I have decided to do my best to
         * explain and demonstrate how these loops work for anyone who is wants to learn
         * about looping or iterating statements in advance. But rest assured, when the
         * topic is taught in class, the code for said topic will also be uploaded but
         * in a different folder with the date it was taught.
         * 
         */

        /*
         * Looping or Iterating Statements - a type of statement that runs code for a
         * finite or infinite number of times.
         * 
         * Different kinds of looping statements:
         * - for
         * - while
         * - do while
         * - for each
         * 
         */

        // for loops
        for (int i = 0; i < 3; i++) {

            System.out.println("For loop: " + i); // prints 3 times
            // the i shows the current iteration

        }

        /*
         * The code above represents a for loop, to better understand this, let us first
         * break down the syntax shown above.
         * 
         * for - setup for making a for loop
         * (int i = 0; - this will be our counter for the loop
         * i < 3 - condition that makes the loop running
         * i++;) - increments or adds 1 to the i
         * {
         * code block that will run 3 times
         * }
         * 
         * The for loop above loops 3 times, this is because most of the time in
         * programming, we start counting from 0 rather than 1. So in the loop above,
         * we start from iteration 0, which is why we set int i = 0 as our starting
         * position. When we run our program it starts from iteration 0, checks if
         * i is less than 3, prints the code block, then increments i by one.
         * 
         * After this, it will then run again, but this time, i will be 1 instead of 0.
         * Since 1 is less than 3, it runs the code block below again and increments i
         * by 1.
         * 
         * i is now equal to 2, i is still less than 3, it runs the code block again.
         * Now i is equal to 3, 3 is not less than 3, so this will end the for loop.
         * 
         * While you can edit the initial i value to another number, I would recommend
         * that you should start at 0 since most of the time, it is the default value
         * that one should use when doing a for loop.
         * 
         */

        // More examples of for loops

        for (int i = 1; i < 2; i++) { // loop that only runs one time

            System.out.println("I only run one time!");
            System.out.println("Loop: " + i);

        }

        System.out.println("For loop but decrements");
        for (int i = 3; i > 0; i--) {

            System.out.println("Loop: " + i);

        }

        /*
         * For now, I would recommend practicing the first for loop shown above since
         * most often than not, this will be the format that we will be using the for
         * loop in
         * 
         */

        // while loop

        int numOne = 3; // variable to be used for demonstration

        while (numOne > 0) { // while numOne is greater than 1, run code below

            System.out.println("While loop: " + numOne); // shows numOne value
            numOne--; // this decrements or subtracts one from numOne each loop

        }

        /*
         * A while loop runs until the condition within the parenthesis return false.
         * In the demonstration above, we decremented the variable that tests the
         * condition. As long as numOne is greater than 0, it will run the code below.
         * 
         * WARNING: DO NOT CREATE INFINITE WHILE LOOPS UNLESS YOU ARE SURE OF WHAT YOU
         * ARE DOING. THIS IS BECAUSE INFINITE WHILE LOOPS MAY CAUSE YOUR EDITOR OR
         * COMPUTER TO CRASH.
         * 
         */

        // do while loop

        int numTwo = 3; // to be used for demonstration

        do { // do code block below

            System.out.println("Do loop: " + numTwo);
            numTwo--;

        } while (numTwo > 0); // while numTwo is greater than 0

        /*
         * Difference of while loop and do while loops, in while loops, the condition
         * needs to return true in order to run once or more. Whereas in do while loops,
         * the code block inside do will run once regardless if the while condition
         * returns true or false.
         * 
         */

        // do while loop with false while condition

        do {

            System.out.println("I only run once!");

        } while (numTwo > 5); // numTwo = 3; it is not greater than 5, returns false
        // runs the code block within the do brackets once even if while condition
        // returns false

        // for each loop

        /*
         * for each loop requires you, the reader, to have some sort of knowledge
         * regarding arrays before understanding how the for each loop works. But
         * regardless, I will try my best to demonstrate to you how a for each
         * loop works.
         * 
         */

        /*
         * First, we will need an array.
         * An array is like a set of variables. Imagine it as like a section for a
         * class, where each person inside that class is a variable and all of them
         * combined makes up a class or array.
         * 
         */

        int[] numArr = { 1, 2, 3, 4, 5, numOne, numTwo }; // array that has multiple integer variables

        // for each loop, a for each loops goes through each item within an array

        for (int eachNum : numArr) {

            System.out.println(eachNum); // prints each item within the array

        }

    }

}