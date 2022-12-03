import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/3/22
 * School: Universidad De Dagupan
 * Description: Variables and Print methods
 * 
 */

public class OutputAndVariables { // remember that the file name should always be the same as the class name
    // class names should be in Pacal Naming Convention

    public static void main(String[] args) { // this is your main method
        // A shortcut for creating the main method is typing in 'main' then press tab

        // First, we will look at the different variables that we will be using

        // Primitive types
        int myInt = 123; // stores integers or whole numbers, 8 bit
        float myFloat = 123.456f; // stores decimals, 32 bit
        double myDouble = 123.456789; // also stores decimals but longer than floats, 64 bit
        char myChar = 'a'; // stores a single character
        boolean myBool = true; // stores either true or false

        // Variable names should be in Camel Naming Convention

        // Non reference types
        String myString = "This is a string"; // Strings
        // For now we will only use strings
        int[] myArray = {1, 2, 3, 4, 5}; // Arrays
        LinkedList <Integer> listOne = new LinkedList<Integer>(); // Linked lists
        Queue <Integer> queueOne = new LinkedList<Integer>(); // Queues
        Stack <Integer> stackOne = new Stack<>(); // Stacks
        // Tuples, will not demonstrate yet

        // Displaying values and messages using the print method

        // Displaying a message
        System.out.println("Hello World"); // prints "Hello World" in terminal

        // System is a class, out is an object or field of that class, and println is
        // the method

        // ln means "line new", this makes sure that after the printing statement, a new
        // line is made after

        // If you only use print instead of println, the next print statement will be
        // on the same line

        // Displaying a variable
        System.out.println(myInt); // prints "123" in the terminal, refer to variables above
        System.out.println(myString); // prints "This is a string"

        // Displaying both a string or message and a variable
        System.out.println("Integer: " + myInt); // prints "Integer: 123"
        System.out.println("String: " + myString); // prints "String: This is a string"
        // We use concatenation to combine our string and varible
        // we use the '+' to concatenate or merge our message and our variable

        // More examples
        System.out.println("Float: " + myFloat + " <- this is a float");
        System.out.println("Double: " + myDouble + " [Ang pogi ni sir]");
        System.out.println("Your answer: " + myBool + " love na ata to");
        System.out.println("Character: " + myChar + "mongus");



    }

}
