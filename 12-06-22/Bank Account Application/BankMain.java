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
         * - Deposit history (Debugging)
         * - Withdraw history (Debugging)
         * - Transfer history (Debugging)
         * - Closing account (deleting account details and withdrawing all account
         * money)
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

        BankAccount machOne = new BankAccount(); // object where all our operations will happen

        machOne.terminalMenu(); // as a challenge, we will not use an infinite while loop

    }

}