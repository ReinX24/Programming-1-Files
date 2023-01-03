import java.util.Scanner;

public class ProgramBlk01B {

    public static void main(String[] args) {

        // First we will create a scanner class to accept user input
        Scanner scanOne = new Scanner(System.in);

        System.out.println("--------------------------------------"); // This is just for decoration
        // Asks for a name
        System.out.print("Enter your name?: ");
        // Here, we are instantiating a variable and at the same time assigning a value to it using our scanner
        String myName = scanOne.nextLine(); // nextLine because it is a string

        System.out.println("--------------------------------------");
        // Asks for an age
        System.out.print("Enter your Age?: ");
        // Again, we instantiate a variable as we assign a value to it sing 
        int myAge = scanOne.nextInt(); // nextInt because it is an integer

        System.out.println("--------------------------------------");
        // Shows name and age
        System.out.println("[Hello " + myName + " you are " + myAge + " years old.]");
        System.out.println("--------------------------------------");

        // Adding if else statements for age

        // Checks if myAge is less than or equal 17, returns true and runs code
        if (myAge <= 17) {

            // Runs if statement above returns true. If not, goes to next statement
            System.out.println("[You are still young!]");

        }

        // If first statement returns false, it will then check if myAge is greater than or equal than 18
        else if (myAge >= 18){

            // Runs if statement above returns true
            System.out.println("[You can be independent!]");

        }

        System.out.println("--------------------------------------");

        scanOne.close(); // Closes the scanner

    }

}