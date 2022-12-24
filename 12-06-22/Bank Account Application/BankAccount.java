import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in); // user inputs
    int userChoice = 0; // user choice

    HashMap<String, String> machAcc = new HashMap<String, String>(); // storing name and password
    HashMap<String, Integer> machFund = new HashMap<String, Integer>(); // storing name and account funds
    HashMap<String, ArrayList<String>> depoHistory = new HashMap<String, ArrayList<String>>(); // deposit history
    HashMap<String, ArrayList<String>> withHistory = new HashMap<String, ArrayList<String>>(); // withdraw history
    HashMap<String, ArrayList<String>> sendHistory = new HashMap<String, ArrayList<String>>(); // transfer history
    HashMap<String, ArrayList<String>> receHistory = new HashMap<String, ArrayList<String>>(); // receive history

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
        // Array List for each HashMap that will store deposit, withdraw, and transfer
        // history
        ArrayList<String> depoList = new ArrayList<String>();
        ArrayList<String> withList = new ArrayList<String>();
        ArrayList<String> sendList = new ArrayList<String>();
        ArrayList<String> receList = new ArrayList<String>();

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

        // put account name and an ArrayLists that will store accounts' processes
        // history
        depoHistory.put(newName, depoList);
        withHistory.put(newName, withList);
        sendHistory.put(newName, sendList);
        receHistory.put(newName, receList);
        terminalMenu(); // returns to menu

    }

    public String makeName(String newName) { // method that asks and returns a name for a new account

        System.out.println("=======================");
        System.out.println("[Sign Up New Account]");
        System.out.println("=======================");
        String newNameCheck = null;

        try {

            System.out.println("[Name Requirements]");
            System.out.println(" > Name Contains 4 Characters or More");
            System.out.println(" > Name Does Not Contain Any Digits");
            System.out.println(" > Name Contains At Least 1 Capital Letter");
            System.out.print("Insert Name: "); // name for new account
            newName = scanOne.next();

            nameRequire(newName);
            // method that checks if all name requirements are met, will distrupt account
            // creation if any of the requirements are not met

            if (machAcc.containsKey(newName)) { // if name already exists, throw message & return terminal menu

                System.out.println("[Account Already Exists]");
                terminalMenu(); // returns to terminal menu without error message

            }

            else {

                System.out.print("Insert Name Again: ");
                newNameCheck = scanOne.next();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError(); // returns to terminal menu with an error message

        }

        if (newName.equals(newNameCheck)) {

            System.out.println("[Account Name Validated]");

        }

        else if (!newName.equals(newNameCheck)) {
            // if the first account name is not equal to the second, print an error message
            // and return to terminal menu

            System.out.println("[Account Names Not Identical]");
            terminalMenu(); // returns to terminal menu

        }

        else {

            machError(); // returns to terminal menu if the first name and second name are different

        }

        return newName; // returns inputted account name

    }

    public void nameRequire(String newName) { // method that checks if all user name requirements are met

        // Checking name length
        if (newName.length() < 4) { // checks the name length

            System.out.println("[Name Length Requirement Not Met (4 Characters)]");
            terminalMenu(); // returns to terminal menu

        }

        // Checking if the name has any digits (it should not have any)
        char[] charArr = newName.toCharArray(); // places String characters in an array
        int digitCount = 0; // counter for the amount of digits in the array
        int capitalCount = 0; // counter for capital letters in the array

        for (int i = 0; i < charArr.length; i++) { // loops through the char array

            if (Character.isDigit(charArr[i])) { // check if the current iterated char is a digit

                digitCount += 1; // if true, add 1 to counter
                // shorthand version of digitCount = digitCount + 1;

            }

        }

        if (digitCount > 0) {

            System.out.println("[Name Must Not Contain Digits]");
            terminalMenu(); // return to terminal menu

        }

        // Checks if any of the characters are in uppercase
        for (int i = 0; i < charArr.length; i++) {
            // loops through the array, to check if any characters are in uppercase letters

            if (Character.isUpperCase(charArr[i])) {

                capitalCount += 1; // add one to capitalCount

            }

        }

        if (capitalCount == 0) {
            // if String has no capital letters, print requirement and return to terminal
            // menu

            System.out.println("[Name Must Contain 1 Capital Letter]");
            terminalMenu(); // return to terminal menu

        }

        else {

            System.out.println("[Verified Name Requirements]");
            // prints if all of the requirements are met and goes through the account
            // creation process

        }

    }

    public String makePass(String newPass) { // method that asks and returns a password for a new account

        String newPassCheck = null; // storage for second password for better security and validation

        try {

            System.out.println("=======================");
            System.out.println("[Password Requirements]");
            System.out.println(" > Password Contains 4 Characters or More");
            System.out.println(" > Password Contains At Least 2 Digits");
            System.out.println(" > Password Contains At Least 1 Capital Letter");
            System.out.print("Insert Password: "); // password for new account
            newPass = scanOne.next();

            // method that checks if the password has 4 characters and has 2 digits in those
            // characters
            passRequire(newPass); // if all requirements are met, ask for password again
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

        else { // if first password is not identical to second password, return to terminal
               // menu

            System.out.println("[Password Not Identical, Try Again]");
            terminalMenu();

        }

        return newPass; // if the passwords are the same, returns the new password

    }

    public void passRequire(String newPass) { // method that checks if the password meets all of the requirements

        if (newPass.length() < 4) { // checks the password length

            System.out.println("[Password Length Requirement Not Met (4 Characters)]");
            terminalMenu(); // returns to terminal menu

        }

        char[] charArr = newPass.toCharArray(); // places String characters in an array
        int digitCount = 0; // counter for the amount of digits in the array
        int capitalCount = 0; // counter for capital letters in the array

        for (int i = 0; i < charArr.length; i++) { // loops through the char array

            if (Character.isDigit(charArr[i])) { // check if the current iterated char is a digit

                digitCount += 1; // if true, add 1 to counter
                // shorthand version of digitCount = digitCount + 1;

            }

        }

        if (digitCount < 2) { // if String has less than 2 digits, print requirement and return to terminal
                              // menu

            System.out.println("[Password Must Contain 2 Digits]");
            terminalMenu(); // return to terminal menu

        }

        for (int i = 0; i < charArr.length; i++) {
            // loops through the array, to check if any characters are in uppercase letters

            if (Character.isUpperCase(charArr[i])) {

                capitalCount += 1; // add one to capitalCount

            }

        }

        if (capitalCount == 0) { // if String has no capital letters, print requirement and return to terminal
                                 // menu

            System.out.println("[Password Must Contain 1 Capital Letter]");
            terminalMenu(); // return to terminal menu

        }

        else {

            System.out.println("[Verified Password Requirements]");

        }

    }

    public String inputName(String accName) { // asks for existing account name

        System.out.println("=======================");
        System.out.println("[Login Account]");
        System.out.println("=======================");

        try {

            System.out.print("Insert Name: ");
            accName = scanOne.next();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();
            machError();

        }

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

                System.out.print("Insert Password Again: "); // asks for the password again
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

        if (accPass.equals(accPassCheck)) { // checks if the first password is similar to second password

            System.out.println("[Password Validated]");

        }

        else { // returns to terminal menu if passwords are not identical

            System.out.println("[Password Not Identical, Try Again]");
            terminalMenu();

        }

        return accPass;

    }

    public void aboutUs() { // about us page of the program

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
        System.out.println("[6] Deposit Log");
        System.out.println("[7] Withdraw Log");
        System.out.println("[8] Transfer Log");
        System.out.println("[9] Logout");
        System.out.println("[0] Close Account");
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
                transferMenu(accName); // transfers funds menu
                break;

            case 4:
                resetNameMenu(accName); // method that goes to name resetting menu
                break;

            case 5:
                resetPassMenu(accName); // method that goes to password resetting menu
                break;

            case 6:
                showDepoHis(accName); // method that shows deposit history
                break;

            case 7:
                showWithHis(accName); // method that shows withdrawal history
                break;

            case 8:
                showSendHis(accName); // method that shows transfer history
                break;

            case 9:
                logOutAcc(); // log out of account, return to terminal
                break;

            case 0:
                closeAccMenu(accName); // method that goes to a menu that gives the user the choice to close their
                // account
                break;

            default:
                returnMenu(accName); // returns to main menu with an error message
                break;

        }

    }

    public void depoFunds(String accName) { // deposit funds menu

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Deposit Funds]");
        System.out.println("------------------");
        System.out.println("< Deposit an amount");
        System.out.println("to account. >");
        System.out.println("------------------");
        System.out.println("[Account Balance: P" + machFund.get(accName) + "]"); // shows account balance
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
                addFunds(accName); // goes to a method that adds funds to account
                break;

            case 2:
                mainMenu(accName); // return to main menu
                break;

            default:
                returnMenu(accName); // returns to menu
                break;

        }

    }

    public void addFunds(String accName) { // method that adds the funds to account

        Integer addFundAmount = 0;
        System.out.println("=======================");
        System.out.println("[Input Deposit Amount]");

        try {

            System.out.print("Input: "); // asks for deposit amount
            addFundAmount = scanOne.nextInt();
            depoConfirm(accName, addFundAmount); // asks for user confirmation or cancellation in depositing funds
            machFund.put(accName, machFund.get(accName) + addFundAmount); // rewrites existing value of the key
            System.out.println("Adding Funds...");
            Thread.sleep(1000); // delays for 1 second
            System.out.println("[P" + addFundAmount + " Deposited]");
            storeDepoHis(accName, addFundAmount); // method that stores deposit details
            mainMenu(accName); // return to main menu

        }

        catch (InputMismatchException | InterruptedException ex) {

            scanOne.nextLine();
            returnMenu(accName); // returns to main menu with error message

        }

    }

    public void depoConfirm(String accName, Integer addFundAmount) { // confirms or cancels depositing funds

        Integer depoConfirmInput = 0; // user choice for this method
        System.out.println("=======================");
        System.out.println("[Depositing P" + addFundAmount + "]"); // shows inputted funds to deposit
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {

            System.out.print("Input: ");
            depoConfirmInput = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (depoConfirmInput) {

            case 1:
                System.out.println("[Deposit Confirmed]"); // prints message and go through the following processes
                System.out.println("=======================");
                break;

            case 2:
                System.out.println("[Deposit Cancelled]");
                System.out.println("[Returning to Main Menu]");
                mainMenu(accName); // returns the user to the main menu if they cancel deposit
                break;

            default:
                returnMenu(accName);
                break;

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
        System.out.println("[Account Balance: P" + machFund.get(accName) + "]"); // shows account balance
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
                minFunds(accName); // goes to a method that subtracts funds from account
                break;

            case 2:
                mainMenu(accName); // return to main menu
                break;

            default:
                returnMenu(accName); // returns to menu with error message
                break;

        }

    }

    public void minFunds(String accName) { // subtracts funds from the account

        Integer withFundAmount = 0;
        System.out.println("=======================");
        System.out.println("[Input Amount to Withdraw]");

        try {

            System.out.print("Input: ");
            withFundAmount = scanOne.nextInt();

            if (withFundAmount <= machFund.get(accName)) { // checks if withdrawal amount less than existing balance

                withConfirm(accName, withFundAmount); // asks for user confirmation or cancellation in withdrawing funds
                machFund.put(accName, machFund.get(accName) - withFundAmount);
                System.out.println("Withdrawing funds...");
                Thread.sleep(1000); // 1 second delay
                System.out.println("[P" + withFundAmount + " Withdrawn]");
                storeWithHis(accName, withFundAmount); // method that records the withdraw using a HashMap
                mainMenu(accName); // returns to main menu

            }

            else if (withFundAmount > machFund.get(accName)) { // if withdraw amount is greater than

                System.out.println("[Insufficient Balance]");
                mainMenu(accName); // returns to main menu

            }

            else {

                returnMenu(accName); // returns to main menu with an error message

            }

        }

        catch (InputMismatchException | InterruptedException ex) {

            scanOne.nextLine();
            returnMenu(accName); // returns if an exception occurs

        }

    }

    public void withConfirm(String accName, Integer withFundAmount) { // confirms or cancels withdrawing funds

        Integer withConfirmInput = 0; // user choice for this method
        System.out.println("=======================");
        System.out.println("[Withdrawing P" + withFundAmount + "]"); // shows inputted withdrawal amount
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {

            System.out.print("Input: ");
            withConfirmInput = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (withConfirmInput) {

            case 1:
                System.out.println("[Withdraw Confirmed]");
                System.out.println("=======================");
                break;

            case 2:
                System.out.println("[Withdraw Cancelled]");
                System.out.println("[Returning to Main Menu]");
                mainMenu(accName);
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void transferMenu(String accName) { // menu for transferring funds

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
                sendConfirm(accName, sendFundAmount, accRecip); // method that asks confirmation from the user
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
                storeSendHis(accName, accRecip, sendFundAmount); // method that records the transferring of funds
                storeReceHis(accName, accRecip, sendFundAmount); // records the receiving of funds to the recepient
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

    public void sendConfirm(String accName, Integer sendFundAmount, String accRecip) {

        Integer sendConfirmInput = 0; // user choice for this method
        System.out.println("=======================");
        System.out.println("[Sending P" + sendFundAmount + "]"); // shows inputted transfer amount
        System.out.println("[To: " + accRecip + "]");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {

            System.out.print("Input: ");
            sendConfirmInput = scanOne.nextInt();

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        switch (sendConfirmInput) {

            case 1:
                System.out.println("[Transfer Confirmed]");
                System.out.println("=======================");
                break;

            case 2:
                System.out.println("[Transfer Cancelled]");
                System.out.println("[Returning to Main Menu]");
                mainMenu(accName);
                break;

            default:
                returnMenu(accName);
                break;

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

    public void resetNameMenu(String accName) { // menu for resetting name

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Reset Account Name]");
        System.out.println("------------------");
        System.out.println("< Reset the current");
        System.out.println("user name of account");
        System.out.println("and assign new one. >");
        System.out.println("------------------");
        System.out.println("[Current Account Name: " + accName + "]"); // shows account name
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
        String newAccNameCheck = null;
        System.out.println("=======================");

        try {

            System.out.println("[Name Requirements]");
            System.out.println(" > Name Contains 4 Characters or More");
            System.out.println(" > Name Does Not Contain Any Digits");
            System.out.println(" > Name Contains At Least 1 Capital Letter");
            System.out.print("Input new name: ");
            newAccName = scanOne.next();

            resetNameRequire(newAccName, accName); // checks if the name meets all requirements

            if (newAccName.equals(accName)) { // checks if new account name is the same with current name

                System.out.println("[Already Current Account Name]");
                mainMenu(accName); // sends the user to the main menu

            }

            else if (machAcc.containsKey(newAccName)) { // checks if account name already exists

                System.out.println("[Account Name Already Used]");
                mainMenu(accName);

            }

            else {

                System.out.print("Input new name again: "); // asks for new name again
                newAccNameCheck = scanOne.next();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        if (newAccName.equals(newAccNameCheck)) { // checks if first name input is the same with the second one

            if (!(newAccName.equals(accName))) { // if new account name is not equal to current account name

                machAcc.put(newAccName, machAcc.get(accName)); // makes a new account name but same password
                machFund.put(newAccName, machFund.get(accName)); // makes a new account but with the same balance

                /*
                 * TODO:
                 * Transfer deposit, withdrawal, and transfer history to the account with the new account name.
                 * 
                 */

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

        }

        else if (!(newAccName.equals(newAccNameCheck))) { // if first name input not identical to second name input

            System.out.println("[New Account Name Not Identical, Try Again]");
            mainMenu(accName);

        }

        else { // when an error occurs

            returnMenu(accName); // return to main menu with an error message

        }

    }

    public void resetNameRequire(String newName, String accName) { // method that checks if all user name requirements are met

        // Checking name length
        if (newName.length() < 4) { // checks the name length

            System.out.println("[Name Length Requirement Not Met (4 Characters)]");
            mainMenu(accName); // returns to main menu of current account

        }

        // Checking if the name has any digits (it should not have any)
        char[] charArr = newName.toCharArray(); // places String characters in an array
        int digitCount = 0; // counter for the amount of digits in the array
        int capitalCount = 0; // counter for capital letters in the array

        for (int i = 0; i < charArr.length; i++) { // loops through the char array

            if (Character.isDigit(charArr[i])) { // check if the current iterated char is a digit

                digitCount += 1; // if true, add 1 to counter
                // shorthand version of digitCount = digitCount + 1;

            }

        }

        if (digitCount > 0) {

            System.out.println("[Name Must Not Contain Digits]");
            mainMenu(accName); // return to main menu

        }

        // Checks if any of the characters are in uppercase
        for (int i = 0; i < charArr.length; i++) {
            // loops through the array, to check if any characters are in uppercase letters

            if (Character.isUpperCase(charArr[i])) {

                capitalCount += 1; // add one to capitalCount

            }

        }

        if (capitalCount == 0) {
            // if String has no capital letters, print requirement and return to terminal
            // menu

            System.out.println("[Name Must Contain 1 Capital Letter]");
            mainMenu(accName); // return to main menu

        }

        else {

            System.out.println("[Verified Name Requirements]");
            // prints if all of the requirements are met and goes through the account
            // creation process

        }

    }

    public void resetPassMenu(String accName) { // menu for resetting account password

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Reset Account Password]");
        System.out.println("------------------");
        System.out.println("< Reset the current");
        System.out.println("password of account");
        System.out.println("and assign new one. >");
        System.out.println("------------------");
        System.out.println("[Current Account Password: " + censorPass(accName) + "]");
        System.out.println("=======================");
        System.out.println("[1] Reset Account Password");
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
                resetPass(accName); // method that asks the user for a new password
                break;

            case 2:
                mainMenu(accName);
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void resetPass(String accName) { // resets password

        String newAccPass = null; // first new password input
        String newAccPassCheck = null; // second new password input
        System.out.println("=======================");
        System.out.println("[Password Requirements]");
        System.out.println(" > Password Contains 4 Characters or More");
        System.out.println(" > Password Contains At Least 2 Digits");
        System.out.println(" > Password Contains At Least 1 Capital Letter");

        try {

            System.out.print("Input new password: ");
            newAccPass = scanOne.next();

            resetPassRequire(newAccPass, accName); // method that checks if all password requirements are met

            if (newAccPass.equals(machAcc.get(accName))) { // checks if new password is the same with old password

                System.out.println("[Already Current Account Password]");
                mainMenu(accName); // sends the user to the main menu

            }

            else {

                System.out.print("Input new password again: ");
                newAccPassCheck = scanOne.next();

            }

        }

        catch (InputMismatchException ex) {

            scanOne.nextLine();

        }

        if (newAccPass.equals(newAccPassCheck)) { // checks if first new password input identical to new second password

            if (!(newAccPass.equals(machAcc.get(accName)))) { // if new pass is not equal to current pass

                machAcc.replace(accName, newAccPass); // replaces old account password with same name but new password
                System.out.println("[Reset Password, Login Again]");
                terminalMenu(); // logs out account and return to terminal menu

            }

        }

        else if (!(newAccPass.equals(newAccPassCheck))) { // if the first pass is not the same with the second pass

            System.out.println("[New Password Not Identical, Try Again]");
            mainMenu(accName);

        }

        else {

            returnMenu(accName);

        }

    }

    public void resetPassRequire(String newPass, String accName) { // method that checks if the password meets all of the requirements

        if (newPass.length() < 4) { // checks the password length

            System.out.println("[Password Length Requirement Not Met (4 Characters)]");
            mainMenu(accName); // returns to main menu

        }

        char[] charArr = newPass.toCharArray(); // places String characters in an array
        int digitCount = 0; // counter for the amount of digits in the array
        int capitalCount = 0; // counter for capital letters in the array

        for (int i = 0; i < charArr.length; i++) { // loops through the char array

            if (Character.isDigit(charArr[i])) { // check if the current iterated char is a digit

                digitCount += 1; // if true, add 1 to counter
                // shorthand version of digitCount = digitCount + 1;

            }

        }

        if (digitCount < 2) { // if String has less than 2 digits, print requirement and return to terminal
                              // menu

            System.out.println("[Password Must Contain 2 Digits]");
            mainMenu(accName);

        }

        for (int i = 0; i < charArr.length; i++) {
            // loops through the array, to check if any characters are in uppercase letters

            if (Character.isUpperCase(charArr[i])) {

                capitalCount += 1; // add one to capitalCount

            }

        }

        if (capitalCount == 0) { // if String has no capital letters, print requirement and return to terminal
                                 // menu

            System.out.println("[Password Must Contain 1 Capital Letter]");
            mainMenu(accName);

        }

        else {

            System.out.println("[Verified Password Requirements]");

        }

    }

    public String censorPass(String accName) { // method that returns the censored password

        String passLength = machAcc.get(accName); // assigns current password to passLength
        String passCensor = ""; // storing for censored password
        char eachChar = '*'; // each password character will be represented as an asterisk

        for (int i = 0; i < passLength.length(); i++) { // loop that determines censored password length

            passCensor = passCensor + eachChar; // add an asterisk for each character in password

        }

        return passCensor; // returns censored password

    }

    public void storeDepoHis(String accName, Integer addFundAmount) { // method that adds the deposit log to HashMap

        // gets the current time and stores it in a String
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());

        // store time and deposit amount in one String
        String depoReceipt = "Time: " + timeStamp + " | Amount: +P" + addFundAmount + "";

        // add time and amount String to the array list that holds the deposit history
        // for this account
        depoHistory.get(accName).add(depoReceipt);

    }

    public void storeWithHis(String accName, Integer withFundAmount) { // method that adds to withdraw log HashMap

        // gets the current time and stores it in a String
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());

        // store time and withdraw amount in one String
        String withReceipt = "Time: " + timeStamp + " | Amount: -P" + withFundAmount + "";

        // add time and amount String to the array list that holds the withdraw history
        // for this account
        withHistory.get(accName).add(withReceipt);

    }

    public void storeSendHis(String accName, String accRecip, Integer sendFundAmount) { // send log added to HashMap

        // gets the current time and stores it in a String
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());

        // store time and sent amount in one String
        String sendReceipt = "Time: " + timeStamp + " | Amount: -P" + sendFundAmount + " | Recipient: " + accRecip;

        // add time and amount String to the array list that holds the sent funds
        // history
        // for this account
        sendHistory.get(accName).add(sendReceipt);

    }

    public void storeReceHis(String accName, String accRecip, Integer receFundAmount) { // receive log added to HashMap

        // gets the current time and stores it in a String
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());

        // store time and received amount in one String
        String receReceipt = "Time: " + timeStamp + " | Amount: +P" + receFundAmount + " | Sender: " + accName;

        // add time and amount String to the array list that holds the received funds
        // history for this account
        receHistory.get(accRecip).add(receReceipt); // adds to received amount history of the recipient

    }

    public void showDepoHis(String accName) { // method that shows deposit history

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Deposit History]");
        System.out.println("------------------");
        System.out.println("< Check the deposit");
        System.out.println("history of the account");
        System.out.println("with time and amount. >");
        System.out.println("------------------");
        System.out.println("=======================");
        System.out.println("[1] Show Deposit Log");
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
                System.out.println("[Deposit History]");
                for (int i = 0; i < depoHistory.get(accName).size(); i++) { // loop that iterates through Array List

                    System.out.print(depoHistory.get(accName).get(i) + "\n");
                    // shows each item in Array List that shows past deposits

                }
                mainMenu(accName); // return to main menu after showing logs

                break;

            case 2:
                mainMenu(accName); // returns to main menu
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void showWithHis(String accName) { // method that shows withdraw history

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Withdraw History]");
        System.out.println("------------------");
        System.out.println("< Check the withdraw");
        System.out.println("history of the account");
        System.out.println("with time and amount. >");
        System.out.println("------------------");
        System.out.println("=======================");
        System.out.println("[1] Show Withdraw Log");
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
                System.out.println("[Withdraw History]");
                for (int i = 0; i < withHistory.get(accName).size(); i++) { // loop that iterates through Array List

                    System.out.print(withHistory.get(accName).get(i) + "\n");
                    // shows each item in Array List that shows past deposits

                }
                mainMenu(accName); // return to main menu after showing logs

                break;

            case 2:
                mainMenu(accName); // returns to main menu
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void showSendHis(String accName) { // method that shows withdraw history

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Transfer History]");
        System.out.println("------------------");
        System.out.println("< Check the transfer");
        System.out.println("history of the account");
        System.out.println("with time and amount. >");
        System.out.println("------------------");
        System.out.println("=======================");
        System.out.println("[1] Show Sent Log");
        System.out.println("[2] Show Received Log");
        System.out.println("[3] Main Menu");
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

                for (int i = 0; i < sendHistory.get(accName).size(); i++) { // loop that iterates through Array List

                    System.out.print(sendHistory.get(accName).get(i) + "\n");
                    // shows each item in Array List that shows past deposits

                }
                mainMenu(accName); // return to main menu after showing logs

                break;

            case 2:
                for (int i = 0; i < receHistory.get(accName).size(); i++) { // for loop that iterates through receList

                    System.out.print(receHistory.get(accName).get(i) + "\n");
                    // shows each item in Array List that shows past deposits

                }
                mainMenu(accName); // return to main menu after showing logs
                break;

            case 3:
                mainMenu(accName); // returns to main menu
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void closeAccMenu(String accName) {

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[Closing Account]");
        System.out.println("------------------");
        System.out.println("< Closes the account,");
        System.out.println("withdraws account funds,");
        System.out.println("and deletes all user");
        System.out.println("information. >");
        System.out.println("------------------");
        System.out.println("=======================");
        System.out.println("[1] Close Account");
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
                closeAccInfo(accName); // shows account info and asks for confirmation
                break;

            case 2:
                mainMenu(accName); // returns to main menu
                break;

            default:
                returnMenu(accName);
                break;

        }

    }

    public void closeAccInfo(String accName) { // menu that shows option description and choices

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("Account Name: " + accName);
        System.out.println("Account Balance: P" + machFund.get(accName));
        System.out.println("=======================");
        System.out.println("[Are you sure you want to delete your account?]");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");
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
                checkUserPass(accName); // asks the user to type their password before deleting the account
                closeAcc(accName); // method that deletes all account information
                break;

            case 2:
                System.out.println("[Deletion Cancelled, Returning to Main Menu]");
                mainMenu(accName);
                break;

            default:
                returnMenu(accName); // returns to main menu with an error message
                break;

        }

    }

    public void closeAcc(String accName) { // method that deletes all account information

        try {

            System.out.println("Deleting Information...");
            Thread.sleep(500);
            System.out.println("Withdrawing Funds...");
            Thread.sleep(500);
            System.out.println("Deleting Account History...");
            Thread.sleep(500);
            System.out.println("[Withdrawn P" + machFund.get(accName) + "]");
            // gets the remaining account funds in machFund
            machAcc.remove(accName);
            machFund.remove(accName);
            depoHistory.remove(accName);
            withHistory.remove(accName);
            sendHistory.remove(accName);
            System.out.println("[Account Deleted, Returning to Login Menu]");
            terminalMenu(); // returns the user to terminal menu

        }

        catch (InterruptedException ex) {

            scanOne.nextLine();
            mainMenu(accName);

        }

    }

    public void logOutAcc() { // logouts of account

        System.out.println("[Logged Out Account]");
        terminalMenu(); // return to terminal menu

    }

    public void returnMenu(String accName) { // returns user to main menu with a error message

        System.out.println("[Not Valid Input, Returning to Menu]");
        mainMenu(accName);

    }

    public void machError() { // returns to terminal menu with an error message

        System.out.println("[Error Occurred, Try Again]");
        terminalMenu(); // returns to termainal menu

    }

}
