import java.util.HashMap;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in); // user inputs
    int userChoice = 0; // user choice

    HashMap<String, String> machAcc = new HashMap<String, String>(); // storing name and password
    HashMap<String, Double> machFund = new HashMap<String, Double>(); // storing name and account funds

    public void terminalMenu() {

        // login menu
        userChoice = 0;
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

        String accName = null;
        String accPass = null;

        // logging into an account

        accName = checkName(accName);

        if (accName != null) {

            accPass = checkPass(accPass);

        }


        if (machAcc.containsKey(accName) && machAcc.containsValue(accPass)) {

            System.out.println("Account logged in!");
            mainMenu(accName);

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

        else {

            System.out.println("[Error, must insert name]");

        }

        System.out.println("[Account Created]");
        machAcc.put(newName, newPass);
        

    }

    public String makeName(String newName) {

        System.out.println("[Sign Up New Account]");
        System.out.print("===============");
        System.out.println("Insert Name: "); // name for new account
        newName = scanOne.next();
        return newName;

    }

    public String makePass(String newPass) {

        System.out.println("===============");
        System.out.print("Insert Password: "); // password for new account
        newPass = scanOne.next();
        return newPass;

    }

    public String checkName(String accName) {

        System.out.println("[Login Account]");
        System.out.println("===============");
        System.out.print("Insert Name: ");
        accName = scanOne.next();
        return accName;

    }

    public String checkPass(String accPass) {

        System.out.println("===============");
        System.out.print("Insert Password: ");
        accPass = scanOne.next();
        return accPass;

    }
        

    public void mainMenu(String accName) {

        // menu for when the user logs in
        System.out.println("[RSE ATM Menu]");
        System.out.println("Current funds: " // account funds here);
        System.out.println("[1] Deposit Funds");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Logout");
        System.out.print("Input: ");
        userChoice

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
