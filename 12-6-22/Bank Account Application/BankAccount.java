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
        System.out.println("=======================");
        System.out.println("[RSE ATM Dagupan]");
        System.out.println("=======================");
        System.out.println("[1] Login");
        System.out.println("[2] Sign Up");
        System.out.println("[3] About Us");
        System.out.println("=======================");
        
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

        System.out.println("=======================");
        System.out.println("[Account Created]"); // will print when account password is created
        System.out.println("Thank you for choosing RSE!");
        System.out.println("Take this as our gift :)");
        System.out.println(newFundAcc + " pesos has been aded to your account!");
        machAcc.put(newName, newPass); // puts name and password in a map
        machFund.put(newName, newFundAcc); // puts account name and funds for said account
        terminalMenu(); // returns to menu

    }

    public String makeName(String newName) { // method that asks and returns a name for a new account

        System.out.println("=======================");
        System.out.println("[Sign Up New Account]");
        System.out.println("=======================");

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

        System.out.println("=======================");
        System.out.println("[Login Account]");
        System.out.println("=======================");
        System.out.print("Insert Name: ");
        accName = scanOne.next();
        return accName;

    }

    public String inputPass(String accPass) { // asks for existing password

        System.out.print("Insert Password: ");
        accPass = scanOne.next();
        return accPass;

    }

    public void mainMenu(String accName) { // main menu when the user logs in

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[RSE ATM Menu]");
        System.out.println("=======================");
        System.out.println("[Welcome " + accName + "]");
        System.out.println("[Current funds: P" + machFund.get(accName) + "]"); // gets the value or funds of account
        System.out.println("=======================");
        System.out.println("[1] Deposit Funds");
        System.out.println("[2] Withdraw Funds");
        System.out.println("[3] Transfer Funds");
        System.out.println("[4] Logout");
        System.out.println("=======================");

        try {

        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
            depoFunds(accName); // deposit funds menu
            break;

            case 2:
            withFunds(accName); // withdraw funds menu
            break;

            case 3:
            transferMenu(accName); // transfers funds to another account
            break;

            case 4:
            logOutAcc(); // log out of account, return to main menu
            break;

            default:
            mainMenu(accName); // returns to main menu
            break;

        }

    }

    public void depoFunds(String accName) { // deposit funds

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Deposit Funds]");
        System.out.println("------------------");
        System.out.println("< Deposit an amount");
        System.out.println("to account. >");
        System.out.println("------------------");
        System.out.println("[Account Balance: P" + machFund.get(accName) + "]");
        System.out.println("=======================");
        System.out.println("[1] Deposit Funds");
        System.out.println("[2] Main Menu");
        System.out.println("=======================");

        try {

        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
            addFunds(accName);
            break;

            case 2:
            mainMenu(accName);
            break;

            default:
            returnMenu(accName); // returns to menu
            break;

        }

    }

    public void addFunds(String accName) {

        Integer addFundAmount = 0; 
        System.out.println("=======================");
        System.out.println("[Input Deposit Amount]");
           
        try {

        System.out.print("Input: ");
        addFundAmount = scanOne.nextInt();
        machFund.put(accName, machFund.get(accName) + addFundAmount); // rewrites existing value of the key
        System.out.println("Adding Funds...");
        Thread.sleep(1000); // delays for 1 second
        System.out.println("[Funds Added]");
        mainMenu(accName); // return to main menu

        }

        catch (InputMismatchException | InterruptedException ex) {

            scanOne.nextLine();
            returnMenu(accName); // returns to main menu with error message

        }

    }

    public void withFunds(String accName) { // withdraws funds
        
        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Withdraw Funds]");
        System.out.println("------------------");
        System.out.println("< Withdraw an amount");
        System.out.println("from account. >");
        System.out.println("------------------");
        System.out.println("[Account Balance: P" + machFund.get(accName) + "]");
        System.out.println("=======================");
        System.out.println("[1] Withdraw Funds");
        System.out.println("[2] Main Menu");
        System.out.println("=======================");

        try {

        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (userChoice) {

            case 1:
            minFunds(accName);
            break;

            case 2:
            mainMenu(accName);
            break;

            default:
            returnMenu(accName); // returns to menu with error message
            break;

        }

    }

    public void minFunds(String accName) {

        Integer withFundAmount = 0;
        System.out.println("=======================");
        System.out.println("[Input Amount to Withdraw]");

        try {

        System.out.print("Input: ");
        withFundAmount = scanOne.nextInt();
        
        if (withFundAmount < machFund.get(accName)) { // checks if withdrawal amount less than existing balance

            machFund.put(accName, machFund.get(accName) - withFundAmount);
            System.out.println("Withdrawing funds...");
            Thread.sleep(1000); // 1 second delay
            System.out.println("[P" + withFundAmount + " Withdrawn]");
            mainMenu(accName); // returns to main menu

        }

        else if (withFundAmount > machFund.get(accName)) { // if withdraw amount is greater than 

            System.out.println("[Insufficient Balance]");
            mainMenu(accName); // returns to main menu

        }

        else {

            returnMenu(accName); // returns to main menu if input not part of choices

        }

    }

    catch (InputMismatchException | InterruptedException ex) {

        scanOne.nextLine();
        returnMenu(accName); // returns if an exception occurs

    }

}

    public void transferMenu(String accName) {

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Transfer Funds]");
        System.out.println("------------------");
        System.out.println("< Transfer an amount");
        System.out.println("from your account to");
        System.out.println("another account. >");
        System.out.println("------------------");
        System.out.println("[Account Balance: P" + machFund.get(accName) + "]");
        System.out.println("=======================");
        System.out.println("[1] Transfer Funds");
        System.out.println("[2] Main Menu");
        System.out.println("=======================");

        try {

        System.out.print("Input: ");
        userChoice = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }


        switch (userChoice) {

            case 1:
            sendFunds(accName); // menu that asks for funds to transfer and account to transfer to
            break;

            case 2:
            mainMenu(accName);
            break;

            default:
            returnMenu(accName);
            break;

        }

    }

    public void sendFunds(String accName) { // sends funds to another account

        Integer sendFundAmount = 0;
        System.out.println("=======================");

        try {
            
        System.out.println("[Input Account Recipient]");
        System.out.print("Input: ");
        String accRecip = scanOne.next();
        System.out.println("[Input Amount to Transfer]");
        System.out.print("Input: ");
        sendFundAmount = scanOne.nextInt();

        if (machFund.containsKey(accRecip)) { // checks if account exists
        
        if (sendFundAmount < machFund.get(accName)) { // checks if transfer amount less than existing balance

            machFund.put(accName, machFund.get(accName) - sendFundAmount); // subtracted funds to be transferred
            System.out.println("Transferring funds...");
            machFund.put(accRecip, machFund.get(accRecip) + sendFundAmount); // adds subtracted funds
            Thread.sleep(1000); // 1 second delay
            System.out.println("[P" + sendFundAmount + " Transferred]");
            mainMenu(accName); // returns to main menu

        }

        else if (sendFundAmount > machFund.get(accName)) { // if withdraw amount is greater than 

            System.out.println("[Insufficient Balance]");
            mainMenu(accName); // returns to main menu

        }

        else {

            returnMenu(accName); // returns to main menu if input not part of choices

        }

    }

    else { // if account does not exist

        System.out.println("[Recipient Not Found]");

    }

    }

    catch (InputMismatchException | InterruptedException ex) {

        scanOne.nextLine();
        returnMenu(accName); // returns if an exception occurs

    }
    }

    public void logOutAcc() { // logouts of account

        System.out.println("[Logged Out Account]");
        terminalMenu();

    }

    public void returnMenu(String accName) {

        System.out.println("[Not Valid Input, Returning to Menu]");
        mainMenu(accName);

    }

    public void machError() {

        System.out.println("[Error Occurred, Try Again]");
        terminalMenu(); // returns to termainal menu

    }

}
