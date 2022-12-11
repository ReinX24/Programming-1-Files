import java.util.Scanner;

class BankMain {

    public static void main(String[] args) {

        /*
         * Menu that will ask the user to create or sign into an account
         * After creating or logging into account, show menu with funds and commands
         * Menu will contain:
         * [Current Funds: show funds]
         * - Deposit funds
         * - Withdraw funds
         * - Logout
         * 
         * When the user logs out, it saves their account in the machine
         */

        BankAccount machOne = new BankAccount();

        while (true) {

        machOne.terminalMenu();

        }

    }

}