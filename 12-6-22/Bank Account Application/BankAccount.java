import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in); // user inputs
    int userChoice = 0; // user choice

    HashMap<String, String> machAcc = new HashMap<String, String>(); // storing name and password
    HashMap<String, Integer> machFund = new HashMap<String, Integer>(); // storing name and account funds

    public void terminalMenu() {

        // Default accounts for testing
        // machAcc.put("admin", "0926");
        // machAcc.put("master", "1234");

        // login menu
        userChoice = 0; // resets userChoice to zero to avoid bugs
        System.out.println("==================");
        System.out.println("[RSE ATM Dagupan]");
        System.out.println("==================");
        System.out.println("[1] Login");
        System.out.println("[2] Sign Up");
        System.out.println("[3] About Us");
        System.out.println("==================");

        try {

            System.out.print("Input: ");
            userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
                loginAcc(); // login menu
                break;

            case 2:
                signUp(); // signup menu
                break;

            default:
                machError(); // throws an error message and returns to main manu
                break;

        }

    }

    public void loginAcc() { // login menu

        userChoice = 0; // resets userChoice
        String accName = null; // account name
        String accPass = null; // account password

        accName = inputName(accName); // goes to a method that asks the user for a name and returns that name
        // assigns the returned name to accName

        if (machAcc.containsKey(accName)) { // checks if the returned name already exists, if it does, ask for password

            accPass = inputPass(accPass); // asks for password and assigns password to accPass

            if (machAcc.get(accName).equals(accPass)) { // gets the value or password of existing account name and 
                // compares it to inserted password

                System.out.println("[Account Logged In]"); // logs into account if inputted password is the same
                mainMenu(accName); // passes account name in main menu to be used for operations
    
            }
    
            else { // if the inputted password is not equal to the account name's password, return to terminal menu
    
                System.out.println("Invalid Credentials, Try Again"); // error message
                terminalMenu(); // returns to menu
    
            }

        }

        else { // if the inputted account name does not match any of the existing account names

            System.out.println("[Account Does Not Exist]");
            terminalMenu();

        }

    }

    public void signUp() { // signing up for an account

        userChoice = 0; // resets userChoice
        String newName = null; // new account name
        String newPass = null; // new account password
        Integer newFundAcc = 20; // free funds when making a new account

        newName = makeName(newName); // goes to a menu that asks for account name and returns account name

        if (newName != null) { // if an account name has been inserted, ask for password for that account

            newPass = makePass(newPass); // asks for a password and returns password

        }

        else { // if no name inserted, return an error message and return to terminal menu

            System.out.println("[Error, must insert name]");
            terminalMenu();

        }

        System.out.println("[Account Created]"); // will print when account password is created
        machAcc.put(newName, newPass); // puts name and password in a map
        machFund.put(newName, newFundAcc); // puts account name and funds for said account
        terminalMenu(); // returns to menu

    }

    public String makeName(String newName) { // method that asks and returns a name for a new account

        System.out.println("==================");
        System.out.println("[Sign Up New Account]");
        System.out.println("==================");

        try {

            System.out.print("Insert Name: "); // name for new account
            newName = scanOne.next();

            if (machAcc.containsKey(newName)) { // if name already exists, throw message and return to terminal menu

                System.out.println("[Account Already Exists]");
                terminalMenu();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError();

        }

        return newName;

    }

    public String makePass(String newPass) { // method that asks and returns a password for a new account

        System.out.println("==================");

        try {

            System.out.print("Insert Password: "); // password for new account
            newPass = scanOne.next();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError();

        }

        return newPass;

    }

    public String inputName(String accName) { // asks for existing account name

        System.out.println("==================");
        System.out.println("[Login Account]");
        System.out.println("==================");
        System.out.print("Insert Name: ");
        accName = scanOne.next();
        return accName;

    }

    public String inputPass(String accPass) { // asks for existing password

        System.out.println("==================");
        System.out.print("Insert Password: ");
        accPass = scanOne.next();
        return accPass;

    }

    public void mainMenu(String accName) { // main menu when the user logs in

        userChoice = 0;
        System.out.println("==================");
        System.out.println("[RSE ATM Menu]");
        System.out.println("==================");
        System.out.println("[Welcome " + accName + "]");
        System.out.println("[Current funds: " + machFund.get(accName) + "]"); // gets the value or funds of account
        System.out.println("==================");
        System.out.println("[1] Deposit Funds");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Logout");
        System.out.println("==================");
        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        switch (userChoice) {

            case 1:

            break;

            case 2:

            break;

            case 3:
            System.out.println("[Logged Out Account]");
            terminalMenu();
            break;

            default:
            mainMenu(accName); // returns to main menu
            break;

        }

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

    public void machError() {

        System.out.println("[Error Occurred, Try Again]");
        terminalMenu(); // returns to termainal menu

    }

}
