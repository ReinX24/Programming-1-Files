import java.util.Scanner; // we will need to import this to use the Scanner class

public class InputScanner {

    public static void main(String[] args) {

        // We will use the Scanner class to accept an input from the user

        // First, we must create an instance of our scanner

        Scanner scanOne = new Scanner(System.in);

        // Let us create variables that will hold our inputs

        String myString = "";
        int myInt = 0;

        // Now we will ask the user for inputs, we will do this by doing the following
        System.out.print("Enter your name: "); // we remove ln so we can type in the same line
        myString = scanOne.nextLine(); // the input of the user will be stored in myString
        // We use .nextLine() because we are inputting a String

        // We will ask for another input
        System.out.print("Enter your age: ");
        myInt = scanOne.nextInt(); // here, we use .nextInt() because we are inputting an integer

        // Now we will show our inputs inside printing statements

        System.out.println("[Your name is " + myString + "]");
        System.out.println("[You are " + myInt + " years old]");

        scanOne.close(); // closes the Scanner

    }

}
