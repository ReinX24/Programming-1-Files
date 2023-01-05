import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scanOne = new Scanner(System.in);
    int userChoice = 0;
    HashMap<String, String> machAcc = new HashMap<String, String>();
    HashMap<String, Integer> machFund = new HashMap<String, Integer>();
    HashMap<String, ArrayList<String>> depoHistory = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> withHistory = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> sendHistory = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> receHistory = new HashMap<String, ArrayList<String>>();

    public void terminalMenu() {

        userChoice = 0;
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
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                loginAcc();
                break;
            case 2:
                signUp();
                break;
            case 3:
                aboutUs();
                break;
            default:
                machError();
                break;
        }

    }

    public void loginAcc() {

        userChoice = 0;
        String accName = null;
        String accPass = null;
        accName = inputName(accName);

        if (machAcc.containsKey(accName)) {
            accPass = inputPass(accName);
            if (machAcc.get(accName).equals(accPass)) {
                System.out.println("[Account Logged In]");
                mainMenu(accName);
            } else {
                System.out.println("Invalid Credentials, Try Again");
                terminalMenu();
            }
        } else {
            System.out.println("[Account Does Not Exist]");
            terminalMenu();
        }

    }

    public void signUp() {

        userChoice = 0;
        String newName = null;
        String newPass = null;
        Integer newFundAcc = 20;
        ArrayList<String> depoList = new ArrayList<String>();
        ArrayList<String> withList = new ArrayList<String>();
        ArrayList<String> sendList = new ArrayList<String>();
        ArrayList<String> receList = new ArrayList<String>();

        newName = makeName(newName);

        if (newName != null) {
            newPass = makePass(newPass);
        } else {
            System.out.println("[Error, must insert name]");
            terminalMenu();
        }

        System.out.println("=======================");
        System.out.println("[Account Created]");
        System.out.println("Thank you for choosing RSE!");
        System.out.println("Take this as our gift :)");
        System.out.println(newFundAcc + " pesos has been aded to your account!");
        machAcc.put(newName, newPass);
        machFund.put(newName, newFundAcc);
        depoHistory.put(newName, depoList);
        withHistory.put(newName, withList);
        sendHistory.put(newName, sendList);
        receHistory.put(newName, receList);
        terminalMenu();

    }

    public String makeName(String newName) {

        System.out.println("=======================");
        System.out.println("[Sign Up New Account]");
        System.out.println("=======================");
        String newNameCheck = null;

        try {
            System.out.println("[Name Requirements]");
            System.out.println(" > Name Contains 4 Characters or More");
            System.out.println(" > Name Does Not Contain Any Digits");
            System.out.println(" > Name Contains At Least 1 Capital Letter");
            System.out.print("Insert Name: ");
            newName = scanOne.nextLine();
            nameRequire(newName);

            if (machAcc.containsKey(newName)) {
                System.out.println("[Account Already Exists]");
                terminalMenu();
            } else {
                System.out.print("Insert Name Again: ");
                newNameCheck = scanOne.nextLine();
            }
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
            machError();
        }

        if (newName.equals(newNameCheck)) {
            System.out.println("[Account Name Validated]");
        } else if (!newName.equals(newNameCheck)) {
            System.out.println("[Account Names Not Identical]");
            terminalMenu();
        } else {
            machError();
        }
        return newName;
    }

    public void nameRequire(String newName) {

        if (newName.length() < 4) {
            System.out.println("[Name Length Requirement Not Met (4 Characters)]");
            terminalMenu();
        }

        char[] charArr = newName.toCharArray();
        int digitCount = 0;
        int capitalCount = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                digitCount += 1;

            }
        }

        if (digitCount > 0) {
            System.out.println("[Name Must Not Contain Digits]");
            terminalMenu();
        }

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                capitalCount += 1;
            }
        }

        if (capitalCount == 0) {
            System.out.println("[Name Must Contain 1 Capital Letter]");
            terminalMenu();
        } else {
            System.out.println("[Verified Name Requirements]");
        }

    }

    public String makePass(String newPass) {

        String newPassCheck = null;

        try {
            System.out.println("=======================");
            System.out.println("[Password Requirements]");
            System.out.println(" > Password Contains 4 Characters or More");
            System.out.println(" > Password Contains At Least 2 Digits");
            System.out.println(" > Password Contains At Least 1 Capital Letter");
            System.out.print("Insert Password: ");
            newPass = scanOne.nextLine();
            passRequire(newPass);
            System.out.print("Insert Password Again: ");
            newPassCheck = scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
            machError();
        }

        if (newPass.equals(newPassCheck)) {
            System.out.println("[Password Validated]");
        } else {
            System.out.println("[Password Not Identical, Try Again]");
            terminalMenu();
        }
        return newPass;
    }

    public void passRequire(String newPass) {

        if (newPass.length() < 4) {
            System.out.println("[Password Length Requirement Not Met (4 Characters)]");
            terminalMenu();
        }

        char[] charArr = newPass.toCharArray();
        int digitCount = 0;
        int capitalCount = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                digitCount += 1;

            }
        }

        if (digitCount < 2) {
            System.out.println("[Password Must Contain 2 Digits]");
            terminalMenu();
        }

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                capitalCount += 1;
            }
        }

        if (capitalCount == 0) {
            System.out.println("[Password Must Contain 1 Capital Letter]");
            terminalMenu();
        } else {
            System.out.println("[Verified Password Requirements]");
        }

    }

    public String inputName(String accName) {

        System.out.println("=======================");
        System.out.println("[Login Account]");
        System.out.println("=======================");

        try {
            System.out.print("Insert Name: ");
            accName = scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
            machError();
        }
        return accName;
    }

    public String inputPass(String accName) {

        String accPassCheck = null;
        String accPass = null;
        String accPassUser = machAcc.get(accName);

        try {
            System.out.print("Insert Password: ");
            accPass = scanOne.nextLine();

            if (accPass.equals(accPassUser)) {
                System.out.print("Insert Password Again: ");
                accPassCheck = scanOne.nextLine();
            } else {
                System.out.println("[Wrong Password, Try Again]");
                terminalMenu();
            }

        } catch (InputMismatchException ex) {
            scanOne.nextLine();
            machError();
        }

        if (accPass.equals(accPassCheck)) {
            System.out.println("[Password Validated]");
        } else {
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
        terminalMenu();

    }

    public void mainMenu(String accName) {

        userChoice = 0;
        System.out.println("=======================");
        System.out.println("[RSE ATM Menu]");
        System.out.println("=======================");
        System.out.println("[Welcome " + accName + "]");
        System.out.println("[Current funds: P" + machFund.get(accName) + "]");
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
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                depoFunds(accName);
                break;
            case 2:
                withFunds(accName);
                break;
            case 3:
                transferMenu(accName);
                break;
            case 4:
                resetNameMenu(accName);
                break;
            case 5:
                resetPassMenu(accName);
                break;
            case 6:
                showDepoHis(accName);
                break;
            case 7:
                showWithHis(accName);
                break;
            case 8:
                showSendHis(accName);
                break;
            case 9:
                logOutAcc();
                break;
            case 0:
                closeAccMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }
    }

    public void depoFunds(String accName) {

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
        } catch (InputMismatchException ex) {
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
                returnMenu(accName);
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
            depoConfirm(accName, addFundAmount);
            machFund.put(accName, machFund.get(accName) + addFundAmount);
            System.out.println("Adding Funds...");
            Thread.sleep(1000);
            System.out.println("[P" + addFundAmount + " Deposited]");
            storeDepoHis(accName, addFundAmount);
            mainMenu(accName);
        } catch (InputMismatchException | InterruptedException ex) {
            scanOne.nextLine();
            returnMenu(accName);
        }

    }

    public void depoConfirm(String accName, Integer addFundAmount) {

        Integer depoConfirmInput = 0;
        System.out.println("=======================");
        System.out.println("[Depositing P" + addFundAmount + "]");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {
            System.out.print("Input: ");
            depoConfirmInput = scanOne.nextInt();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (depoConfirmInput) {
            case 1:
                System.out.println("[Deposit Confirmed]");
                System.out.println("=======================");
                break;
            case 2:
                System.out.println("[Deposit Cancelled]");
                System.out.println("[Returning to Main Menu]");
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }
    }

    public void withFunds(String accName) {

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
        } catch (InputMismatchException ex) {
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
                returnMenu(accName);
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

            if (withFundAmount <= machFund.get(accName)) {
                withConfirm(accName, withFundAmount);
                machFund.put(accName, machFund.get(accName) - withFundAmount);
                System.out.println("Withdrawing funds...");
                Thread.sleep(1000);
                System.out.println("[P" + withFundAmount + " Withdrawn]");
                storeWithHis(accName, withFundAmount);
                mainMenu(accName);
            } else if (withFundAmount > machFund.get(accName)) {
                System.out.println("[Insufficient Balance]");
                mainMenu(accName);
            } else {
                returnMenu(accName);
            }

        }

        catch (InputMismatchException | InterruptedException ex) {
            scanOne.nextLine();
            returnMenu(accName);
        }

    }

    public void withConfirm(String accName, Integer withFundAmount) {

        Integer withConfirmInput = 0;
        System.out.println("=======================");
        System.out.println("[Withdrawing P" + withFundAmount + "]");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {
            System.out.print("Input: ");
            withConfirmInput = scanOne.nextInt();
        } catch (InputMismatchException ex) {
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
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                sendFunds(accName);
                break;
            case 2:
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }
    }

    public void sendFunds(String accName) {

        Integer sendFundAmount = 0;
        System.out.println("=======================");

        try {
            System.out.println("[Input Account Recipient]");
            System.out.print("Input: ");
            String accRecip = scanOne.nextLine();

            if (machFund.containsKey(accRecip)) {
                System.out.println("[Input Amount to Transfer]");
                System.out.print("Input: ");
                sendFundAmount = scanOne.nextInt();
                sendConfirm(accName, sendFundAmount, accRecip);
                checkUserPass(accName);
                sendFundsValid(accName, sendFundAmount, accRecip);
            } else {
                System.out.println("[Recipient Not Found]");
                mainMenu(accName);
            }

        } catch (InputMismatchException ex) {
            scanOne.nextLine();
            returnMenu(accName);
        }
    }

    public void sendFundsValid(String accName, Integer sendFundAmount, String accRecip) {

        try {
            if (sendFundAmount <= machFund.get(accName)) {
                machFund.put(accName, machFund.get(accName) - sendFundAmount);
                System.out.println("Transferring funds...");
                machFund.put(accRecip, machFund.get(accRecip) + sendFundAmount);
                Thread.sleep(1000);
                System.out.println("[P" + sendFundAmount + " Transferred]");
                storeSendHis(accName, accRecip, sendFundAmount);
                storeReceHis(accName, accRecip, sendFundAmount);
                mainMenu(accName);
            } else if (sendFundAmount > machFund.get(accName)) {
                System.out.println("[Insufficient Balance]");
                mainMenu(accName);
            } else {
                returnMenu(accName);
            }
        } catch (InterruptedException ex) {
            scanOne.nextLine();
            returnMenu(accName);
        }
    }

    public void sendConfirm(String accName, Integer sendFundAmount, String accRecip) {

        Integer sendConfirmInput = 0;
        System.out.println("=======================");
        System.out.println("[Sending P" + sendFundAmount + "]");
        System.out.println("[To: " + accRecip + "]");
        System.out.println("[1] Confirm");
        System.out.println("[2] Cancel");

        try {
            System.out.print("Input: ");
            sendConfirmInput = scanOne.nextInt();
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
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

    public void checkUserPass(String accName) {

        String accPassCheck = null;
        String accPass = null;
        String accPassCurrent = machAcc.get(accName);

        try {
            System.out.print("Insert Password: ");
            accPass = scanOne.nextLine();

            if (accPass.equals(accPassCurrent)) {
                System.out.print("Insert Password Again: ");
                accPassCheck = scanOne.nextLine();
            } else {
                System.out.println("[Incorrect Password]");
                mainMenu(accName);
            }
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        if (accPass.equals(accPassCheck)) {
            System.out.println("[Password Validated]");
        } else {
            System.out.println("[Password Not Identical, Try Again]");
            mainMenu(accName);
        }

    }

    public void resetNameMenu(String accName) {

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
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                checkUserPass(accName);
                resetName(accName);
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
            newAccName = scanOne.nextLine();
            resetNameRequire(newAccName, accName);

            if (newAccName.equals(accName)) {
                System.out.println("[Already Current Account Name]");
                mainMenu(accName);
            } else if (machAcc.containsKey(newAccName)) {
                System.out.println("[Account Name Already Used]");
                mainMenu(accName);
            } else {
                System.out.print("Input new name again: ");
                newAccNameCheck = scanOne.nextLine();
            }

        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        if (newAccName.equals(newAccNameCheck)) {

            if (!(newAccName.equals(accName))) {
                machAcc.put(newAccName, machAcc.get(accName));
                machFund.put(newAccName, machFund.get(accName));
                depoHistory.put(newAccName, depoHistory.get(accName));
                withHistory.put(newAccName, withHistory.get(accName));
                sendHistory.put(newAccName, sendHistory.get(accName));
                receHistory.put(newAccName, receHistory.get(accName));
                machAcc.remove(accName);
                machFund.remove(accName);
                depoHistory.remove(accName);
                withHistory.remove(accName);
                sendHistory.remove(accName);
                receHistory.remove(accName);
                System.out.println("[Reset Name, Login Again]");
                terminalMenu();
            }

        } else if (!(newAccName.equals(newAccNameCheck))) {
            System.out.println("[New Account Name Not Identical, Try Again]");
            mainMenu(accName);
        } else {
            returnMenu(accName);
        }

    }

    public void resetNameRequire(String newName, String accName) {

        if (newName.length() < 4) {
            System.out.println("[Name Length Requirement Not Met (4 Characters)]");
            mainMenu(accName);
        }

        char[] charArr = newName.toCharArray();
        int digitCount = 0;
        int capitalCount = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                digitCount += 1;

            }
        }

        if (digitCount > 0) {
            System.out.println("[Name Must Not Contain Digits]");
            mainMenu(accName);
        }

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                capitalCount += 1;
            }
        }

        if (capitalCount == 0) {
            System.out.println("[Name Must Contain 1 Capital Letter]");
            mainMenu(accName);
        } else {
            System.out.println("[Verified Name Requirements]");
        }

    }

    public void resetPassMenu(String accName) {

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
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                checkUserPass(accName);
                resetPass(accName);
                break;
            case 2:
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }

    }

    public void resetPass(String accName) {

        String newAccPass = null;
        String newAccPassCheck = null;
        System.out.println("=======================");
        System.out.println("[Password Requirements]");
        System.out.println(" > Password Contains 4 Characters or More");
        System.out.println(" > Password Contains At Least 2 Digits");
        System.out.println(" > Password Contains At Least 1 Capital Letter");

        try {
            System.out.print("Input new password: ");
            newAccPass = scanOne.nextLine();
            resetPassRequire(newAccPass, accName);

            if (newAccPass.equals(machAcc.get(accName))) {
                System.out.println("[Already Current Account Password]");
                mainMenu(accName);
            } else {
                System.out.print("Input new password again: ");
                newAccPassCheck = scanOne.nextLine();
            }

        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        if (newAccPass.equals(newAccPassCheck)) {
            if (!(newAccPass.equals(machAcc.get(accName)))) {
                machAcc.replace(accName, newAccPass);
                System.out.println("[Reset Password, Login Again]");
                terminalMenu();
            }
        } else if (!(newAccPass.equals(newAccPassCheck))) {
            System.out.println("[New Password Not Identical, Try Again]");
            mainMenu(accName);
        } else {
            returnMenu(accName);
        }

    }

    public void resetPassRequire(String newPass, String accName) {

        if (newPass.length() < 4) {
            System.out.println("[Password Length Requirement Not Met (4 Characters)]");
            mainMenu(accName);
        }

        char[] charArr = newPass.toCharArray();
        int digitCount = 0;
        int capitalCount = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                digitCount += 1;

            }
        }

        if (digitCount < 2) {
            System.out.println("[Password Must Contain 2 Digits]");
            mainMenu(accName);
        }

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                capitalCount += 1;
            }
        }

        if (capitalCount == 0) {
            System.out.println("[Password Must Contain 1 Capital Letter]");
            mainMenu(accName);
        } else {
            System.out.println("[Verified Password Requirements]");
        }

    }

    public String censorPass(String accName) {

        String passLength = machAcc.get(accName);
        String passCensor = "";
        char eachChar = '*';

        for (int i = 0; i < passLength.length(); i++) {
            passCensor = passCensor + eachChar;
        }
        return passCensor;

    }

    public void storeDepoHis(String accName, Integer addFundAmount) {

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
        String depoReceipt = "Time: " + timeStamp + " | Amount: +P" + addFundAmount + "";
        depoHistory.get(accName).add(depoReceipt);

    }

    public void storeWithHis(String accName, Integer withFundAmount) {

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
        String withReceipt = "Time: " + timeStamp + " | Amount: -P" + withFundAmount + "";
        withHistory.get(accName).add(withReceipt);

    }

    public void storeSendHis(String accName, String accRecip, Integer sendFundAmount) {

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
        String sendReceipt = "Time: " + timeStamp + " | Amount: -P" + sendFundAmount + " | Recipient: " + accRecip;
        sendHistory.get(accName).add(sendReceipt);

    }

    public void storeReceHis(String accName, String accRecip, Integer receFundAmount) {

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
        String receReceipt = "Time: " + timeStamp + " | Amount: +P" + receFundAmount + " | Sender: " + accName;
        receHistory.get(accRecip).add(receReceipt);

    }

    public void showDepoHis(String accName) {

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
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                System.out.println("[Deposit History]");
                for (int i = 0; i < depoHistory.get(accName).size(); i++) {
                    System.out.print(depoHistory.get(accName).get(i) + "\n");
                }
                mainMenu(accName);
                break;
            case 2:
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }

    }

    public void showWithHis(String accName) {

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
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                System.out.println("[Withdraw History]");
                for (int i = 0; i < withHistory.get(accName).size(); i++) {
                    System.out.print(withHistory.get(accName).get(i) + "\n");

                }
                mainMenu(accName);
                break;
            case 2:
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }

    }

    public void showSendHis(String accName) {

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
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                for (int i = 0; i < sendHistory.get(accName).size(); i++) {
                    System.out.print(sendHistory.get(accName).get(i) + "\n");
                }
                mainMenu(accName);
                break;
            case 2:
                for (int i = 0; i < receHistory.get(accName).size(); i++) {
                    System.out.print(receHistory.get(accName).get(i) + "\n");
                }
                mainMenu(accName);
                break;
            case 3:
                mainMenu(accName);
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
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                closeAccInfo(accName);
                break;
            case 2:
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }

    }

    public void closeAccInfo(String accName) {

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
            scanOne.nextLine();
        } catch (InputMismatchException ex) {
            scanOne.nextLine();
        }

        switch (userChoice) {
            case 1:
                checkUserPass(accName);
                closeAcc(accName);
                break;
            case 2:
                System.out.println("[Deletion Cancelled, Returning to Main Menu]");
                mainMenu(accName);
                break;
            default:
                returnMenu(accName);
                break;
        }

    }

    public void closeAcc(String accName) {

        try {
            System.out.println("Deleting Information...");
            Thread.sleep(500);
            System.out.println("Withdrawing Funds...");
            Thread.sleep(500);
            System.out.println("Deleting Account History...");
            Thread.sleep(500);
            System.out.println("[Withdrawn P" + machFund.get(accName) + "]");
            machAcc.remove(accName);
            machFund.remove(accName);
            depoHistory.remove(accName);
            withHistory.remove(accName);
            sendHistory.remove(accName);
            System.out.println("[Account Deleted, Returning to Login Menu]");
            terminalMenu();
        } catch (InterruptedException ex) {
            scanOne.nextLine();
            mainMenu(accName);
        }

    }

    public void logOutAcc() {
        System.out.println("[Logged Out Account]");
        terminalMenu();
    }

    public void returnMenu(String accName) {
        System.out.println("[Not Valid Input, Returning to Menu]");
        mainMenu(accName);
    }

    public void machError() {
        System.out.println("[Error Occurred, Try Again]");
        terminalMenu();
    }

}
