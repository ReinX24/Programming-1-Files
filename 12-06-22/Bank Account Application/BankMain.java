/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/11/22
 * School: Universidad De Dagupan
 * Description: Bank Application with Account Creation and Storage using HashMaps
 * 
 */

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
         * All user data is lost when program is terminated
         * 
         */

        /*
         * 12/11/22
         * To do: (To be debugged and further tested)
         * - Add functionality that transfers an account's funds to another account
         * For us to finish this, we would need to input an account name that exists,
         * get that
         * account's corresponding balance, and transfer funds to that account.
         * 
         */

        /*
         * 12/12/22
         * Update: debugging finished, no glaring bugs have been found as of now
         * To do: Apply security features that makes the user type their password twice
         * when signing
         * up and logging into their account. The option for the user to change their
         * password will
         * also be implemented or at least be in development.
         * List of features to be implememted
         * - Reset Password (Done)
         * - Reset User Name (Done)
         * - Confirmation before depositing (Done)
         * - Confirmation before withdrawing (Done)
         * - Confirmation before transferring (Done)
         * - Deposit history (Done)
         * - Withdraw history (Done)
         * - Transfer history (Done)
         * - Closing account (deleting account details and withdrawing all account
         * money) (Done)
         * 
         */

        /*
         * 12/15/22
         * Update, finished most of the features that show the history of deposits,
         * withdrawals, and fund transfers. The last feature that will be added is
         * the deletion of the current account if the user wishes to close their
         * account. Debugging of the newly added features will be done first before
         * adding this closing account function.
         * 
         */

        /*
         * 12/16/22
         * Fixed bugs such as when showing deposit history, it also shows the withdrawal
         * history. The reason for this bug is because they all refer to the same array
         * list that was used to instantiate the different hashmaps that store the
         * different transaction histories that happen throughout the program. I
         * expected that when putting them inside a hashmap will prompt them to all
         * create their own variable rather than all referring to the same list but I
         * was mistaken.
         * 
         * Another bug that has been squashed is the bug that shows the account password
         * intead of the account balance when the user chooses to delete their account.
         * 
         * As for now these are all the bugs that have been found within the program.
         * 
         * Features to add:
         * - Add receive history when receiving funds from another account. (Done)
         * 
         */

        /*
         * 12/19/22
         * Debugging transfer feature between accounts has been done. Future features
         * that are planned to be added in the future are:
         * - Require username and password to be 4 or more characters (Done)
         * - Password must contain a capital letter and two numbers (Done)
         * 
         */

        /*
         * 12/20/22
         * Debugging of the last 2 features (see note above) has not been finished.
         * Further manual testing and debugging for these features has not been done
         * yet. But for now they seem to be functional and are working accordingly
         * to their desired functions.
         * 
         */

        /*
         * 12/22/22
         * Debugged last two features (username and password needing at least 4
         * characters and password requiring a capital letter and 2 numbers).
         * To do:
         * - Name requires at least one capital letter (Done)
         * - Make code structure more "readable" (I will do my best)
         * 
         */

        /*
         * 12/23/22
         * To do:
         * - If the user changes their name, check if they meet requirements (Debugging)
         * - If the user changes password, check if requirements are met (Debugging)
         * - When changing account name, transfer history (causes an error when changing
         * account name and showing deposit history)
         * 
         */

        BankAccount machOne = new BankAccount(); // object where all our operations will happen

        machOne.terminalMenu(); // as a challenge, we will not use an infinite while loop

    }

}