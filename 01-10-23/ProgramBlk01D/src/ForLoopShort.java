import java.util.Scanner;

public class ForLoopShort {

    public static void main(String[] args) {
        // Shortened version of the for loop activity in Main.java
        Scanner scanOne = new Scanner(System.in);
        System.out.print("Enter your name?: ");
        String fullName = scanOne.nextLine();
        System.out.print("Enter your age?: ");
        int userAge = scanOne.nextInt();
        for (int i = 10; i >= 0; i--) { System.out.println("[" + i + "]: " + " Hello " + fullName + " you are " + userAge + " yrs. old!"); }
        scanOne.close(); 
    }
    
}
