import java.util.Scanner;

/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/11/22
 * School: Universidad De Dagupan
 * Description: Can Spell Application
 * 
 */

public class CanSpellMain {

    public static void main(String[] args) {

        /*
         * This is a program that takes a set of characters from the user (String), and
         * finds out of that String can spell a certain String inputted by the user
         * 
         */

        // Scanner to accept user input
        Scanner scanOne = new Scanner(System.in);

        // Title
        System.out.println("[Can Spell Program]");

        // Ask for first String or set of characters
        System.out.print("Input set of characters (no numbers): ");
        String charSet = scanOne.nextLine(); // assigns user input in charSet

        // Before anything, we must check if the set of characters contains a number,
        // our program must NOT contain a number

        if (charSet.length() > 0) { // checks if the user input has any characters

            String charSetTest = charSet; // stores the user input in another variable for testing

            char[] charArr = charSetTest.toCharArray(); // makes each character in the String an element of an array

            for (int i = 0; i < charArr.length; i++) { // loop that iterates through character array

                if (Character.isDigit(charArr[i])) {

                    System.out.println("[Invalid Set, the character set contains a number]");
                    scanOne.close(); // closes Scanner before terminating program
                    return; // terminates the program, returns to the main method

                }

            }

        }

        // Ask for the word that the user wants to spell
        System.out.print("Input word to spell (no numbers): ");
        String userWord = scanOne.nextLine(); // stores the user's word in userWord

        // Checking again if our desired word has any numbers

        if (userWord.length() > 0) { // checks if the user input has any characters

            String charSetTest = userWord; // stores the user input in the userChar

            char[] charArr = charSetTest.toCharArray(); // makes each character in the String an element of an array

            for (int i = 0; i < charArr.length; i++) { // loop that iterates through character array

                if (Character.isDigit(charArr[i])) {

                    System.out.println("[Invalid Set, the user word contains a number]");
                    scanOne.close(); // closes Scanner before terminating program
                    return; // terminates the program

                }

            }

        }

        int MAX_NUM = 256; // number of corresponding bits

        int[] charFreq = new int[MAX_NUM];
        // array that will hold each character frequency by using their bit placement

        // Looping through charSet to record our characters

        for (int i = 0; i < charSet.length(); i++) {

            charFreq[charSet.charAt(i)]++; // increments character's corresponding int value

        }

        // Looping through userWord to find out if we can spell the word using charSet

        for (int i = 0; i < userWord.length(); i++) {

            charFreq[userWord.charAt(i)]--;
            // decrements the corresponding int value, this is because we are using that
            // letter to spell the word

            if (charFreq[userWord.charAt(i)] < 0) {
                // if the corresponding number goes into negative, the word that the user cannot
                // spell their inputted word

                System.out.println("[ X CANNOT Spell [" + userWord + "] with [" + charSet + "] character set]");
                scanOne.close(); // closes the Scanner
                return; // terminates the program

            }

        }

        // Prints if the user can spell their desired word with their character set
        System.out.println("[ / CAN Spell [" + userWord + "] with [" + charSet + "] character set]");

        scanOne.close(); // closes the Scanner

    }

}