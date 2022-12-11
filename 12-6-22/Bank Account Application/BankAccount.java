import java.util.HashMap;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in); // user inputs
    int userChoice = 0;

    // Testing hashset
    HashMap<String, String> machAcc = new HashMap<String, String>();

    public void terminalMenu() {

        // login menu
        System.out.println("[RSE ATM Dagupan]");
        System.out.println("[1] Login");
        System.out.println("[2] Sign Up");
        System.out.print("> ");
        userChoice = scanOne.nextInt();

        switch (userChoice) {

            case 1:
                loginAcc();
                break;

            case 2:
                signUp();
                break;

            default:
                // throws an error message and returns to main manu
                break;

        }

    }

    public void loginAcc() {

        String accName;
        String accPass;

        // logging into an account
        System.out.println("[Login Account]");
        System.out.println("Insert Name");
        System.out.print("> ");
        accName = scanOne.nextLine();
        System.out.println("\nInsert Password");
        System.out.print("> ");
        accPass = scanOne.nextLine();

        if (machAcc.containsKey(accName) && machAcc.containsKey(accPass)) {

            System.out.println("Account logged in!");

        }

        else {

            System.out.println("Wrong credentials");

        }

    }

    public void signUp() {

        // signing up for an account

        String newName = null;
        String newPass = null;

        newName = makeName(newName);

        if (newName != null) {

        newPass = makePass(newPass);

        }

        System.out.println("[Account Created]");
        machAcc.put(newName, newPass);

    }

    public String makeName(String newName) {

        System.out.println("[Sign Up New Account]");
        System.out.println("Insert Name"); // name for new account
        System.out.print("> ");
        newName = scanOne.nextLine();
        return newName;

    }

    public String makePass(String newPass) {

        System.out.println("Insert Password"); // password for new account
        System.out.print("> ");
        newPass = scanOne.nextLine();
        return newPass;

    }
        

    public void mainMenu() {

        // menu for when the user logs in

    }

    public void withFunds() {

        // withdraws funds

    }

    public void depoFunds() {

        // deposit funds

    }

    public void logOutAcc() {

        // logouts of account

    }

}
