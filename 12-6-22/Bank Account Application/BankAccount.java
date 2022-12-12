import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in); // user inputs
    int userChoice = 0; // user choice

    HashMap<String, String> machAcc = new HashMap<String, String>(); // storing name and password
    HashMap<String, Integer> machFund = new HashMap<String, Integer>(); // storing name and account funds

    public void terminalMenu() { // login menu

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

            case 3:
                aboutUs(); // shows about us section
                break;

            default:
                machError(); // throws an error message and returns to terminal menu
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

            accPass = inputPass(accName); // asks for password and assigns password to accPass

            if (machAcc.get(accName).equals(accPass)) { // gets the value or password of existing account name and
                // compares it to inserted password

                System.out.println("[Account Logged In]"); // logs into account if inputted password is the same
                mainMenu(accName); // passes account name in main menu to be used for operations

            }

            else { // if the inputted password is not equal to the account name's password, return
                   // to terminal menu

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

        String newPassCheck = null; // storage for second password for better security and validation

        try {

            System.out.print("Insert Password: "); // password for new account
            newPass = scanOne.next();
            System.out.print("Insert Password Again: "); // asks for password again
            newPassCheck = scanOne.next();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError();

        }

        if (newPass.equals(newPassCheck)) { // checking if first password is the same as the second inputted password

            System.out.println("[Password Validated]"); // prints message if true

        }

        else { // if the first password is not the same with the second password, return to
               // terminal menu

            System.out.println("[Password Not Identical, Try Again]");
            terminalMenu();

        }

        return newPass; // if the passwords are the same, returns the new password

    }

    public String inputName(String accName) { // asks for existing account name

        System.out.println("=======================");
        System.out.println("[Login Account]");
        System.out.println("=======================");
        System.out.print("Insert Name: ");
        accName = scanOne.next();
        return accName;

    }

    public String inputPass(String accName) { // asks for existing password

        String accPassCheck = null;
        String accPass = null;
        String accPassUser = machAcc.get(accName); // gets account password

        try {

            System.out.print("Insert Password: ");
            accPass = scanOne.next();

            if (accPass.equals(accPassUser)) { // checks if the password input is equal to account password

                System.out.print("Insert Password Again: ");
                accPassCheck = scanOne.next();

            }

            else {

                System.out.println("[Wrong Password, Try Again]");
                terminalMenu();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError();

        }

        if (accPass.equals(accPassCheck)) {

            System.out.println("[Password Validated]");

        }

        else {

            System.out.println("[Password Not Identical, Try Again]");
            terminalMenu();

        }

        return accPass;

    }

    public void aboutUs() {

        System.out.println("=======================");
        System.out.println("[About RSE]");
        System.out.println("-----------------------");
        System.out.println("< Rein Solis Enterprises");
        System.out.println("or RSE was established");
        System.out.println("to make digital servies");
        System.out.println("easily available to all");
        System.out.println("people in the Philippines");
        System.out.println("and other countries. >");
        System.out.println("-----------------------");
        terminalMenu(); // returns to terminal menu

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
        System.out.println("[4] Reset Account Name");
        System.out.println("[5] Reset Account Password");
        System.out.println("[6] Logout");
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
                resetNameMenu(accName); // method that goes to name resetting menu
                break;

            case 5:
                // method that goes to password resetting menu
                break;

            case 6:
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
            System.out.println("[P" + addFundAmount + " Deposited]");
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

            if (withFundAmount <= machFund.get(accName)) { // checks if withdrawal amount less than existing balance

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

            System.out.println("[Input Account Recipient]"); // asks user to input recipient account name
            System.out.print("Input: ");
            String accRecip = scanOne.next();

            if (machFund.containsKey(accRecip)) { // checks if account exists

                System.out.println("[Input Amount to Transfer]"); // if the account exists, ask for transfer amount
                System.out.print("Input: ");
                sendFundAmount = scanOne.nextInt();
                checkUserPass(accName); // method that asks for user password two times, for security purposes
                sendFundsValid(accName, sendFundAmount, accRecip); // method that processes transfer of funds

            }

            else { // if account does not exist

                System.out.println("[Recipient Not Found]");
                mainMenu(accName); // returns to main menu if the recipient does is not found

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            returnMenu(accName); // returns if an exception occurs

        }
    }

    public void sendFundsValid(String accName, Integer sendFundAmount, String accRecip) {

        try {

            if (sendFundAmount <= machFund.get(accName)) { // checks if transfer amount less than existing balance

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

        catch (InterruptedException ex) {

            scanOne.nextLine();
            returnMenu(accName); // returns if an exception occurs

        }

    }

    public void checkUserPass(String accName) { // method that asks current user to input password twice

        String accPassCheck = null;
        String accPass = null;
        String accPassCurrent = machAcc.get(accName); // stores current user password in accPassCurrent for validation

        try {

            System.out.print("Insert Password: ");
            accPass = scanOne.next();

            if (accPass.equals(accPassCurrent)) { // checks if inputted password is the current account password

                System.out.print("Insert Password Again: "); // asks the user to type password again
                accPassCheck = scanOne.next();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        if (accPass.equals(accPassCheck)) { // checks if the first input password is the same as the second password

            System.out.println("[Password Validated]");

        }

        else {

            System.out.println("[Password Not Identical, Try Again]");
            mainMenu(accName);

        }

    }

    public void resetNameMenu(String accName) { // menu for restarting name

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Reset Account Name]");
        System.out.println("------------------");
        System.out.println("< Reset the current");
        System.out.println("user name of account");
        System.out.println("and assign new one. >");
        System.out.println("------------------");
        System.out.println("[Current Account Name: " + accName + "]");
        System.out.println("=======================");
        System.out.println("[1] Reset Account Name");
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
                checkUserPass(accName); // method that asks to type account 2 times
                resetName(accName); // method that asks the user for a new name
                break;

            case 2:
                mainMenu(accName);
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void resetName(String accName) {

        String newAccName = null;
        System.out.println("=======================");

        try {

        System.out.print("Input new name: ");
        newAccName = scanOne.next();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        } 

        if (newAccName.equals(accName)) { // checks if new account name is the same with current name

            System.out.println("[Already Current Account Name]");
            mainMenu(accName); // sends the user to the main menu

        }

        else if (machAcc.containsKey(newAccName)) { // checks if account name already exists

            System.out.println("[Account Name Already Used]");
            mainMenu(accName);

        }

        else if (!(newAccName.equals(accName))) { // if new account name is not equal to current account name

            machAcc.put(newAccName, machAcc.get(accName)); // makes a new account in the hashmap but the same password
            machFund.put(newAccName, machFund.get(accName)); // makes a new account but with the same balance
            machAcc.remove(accName); // deletes old account name and password
            machFund.remove(accName); // delets old account name and balance
            System.out.println("[Reset Name, Login Again]");
            terminalMenu(); // logs out account and return to terminal menu

            /*
             * Why did we put new keys and values instead of editing them directly?
             * 
             * The reason why we had to somewhat make new accounts instead of editing the
             * old one is because the keys inside a hashmap cannot be edited once they have
             * been instantiated. So instead, we put new keys and values in the map instead
             * and remove the old ones. While this changes the places of the keys and values
             * inside the map, this will not directly affect the user experience in any way 
             * or form.
             * 
             */

        }

        else {

            returnMenu(accName);

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
