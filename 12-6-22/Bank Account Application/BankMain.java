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
         */

        /*
         * 12/11/22
         * To do:
         * - Add functionality that transfers an account's funds to another account
         * For us to finish this, we would need to input an account name that exists, get that
         * account's corresponding balance, and transfer funds to that account.
         * 
         */

        BankAccount machOne = new BankAccount(); // object where all our operations will happen

        machOne.terminalMenu(); // as a challenge, we will not use an infinite while loop


    }

}