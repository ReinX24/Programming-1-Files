public class ShiftCypherMain {

    public static void main(String[] args) {

        /*
         * Shift Cypher Program: Refer to Page 159 to 160 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        String plainStr = "SECRETZEN"; // our original message
        String encryptStr = ""; // our encrypted version of the message
        int encryptKey = 3; // how much we will shift the text to the right

        // Make plain String into lowercase
        String lowerPlainStr = plainStr.toLowerCase();

        // For loop that iterates through the String and Encrypts the message
        for (int i = 0; i < lowerPlainStr.length(); i++) {
            int currentChar = lowerPlainStr.charAt(i); // converts character into its decimal value in ASCII
            currentChar -= 'a'; // makes it into a number (0 - 25)
            currentChar += encryptKey; // shifts 3 places to the right, A -> D

            if (currentChar >= 26) { // if it goes beyond 26 (letters of the alphabet)
                currentChar -= 26; // subtract by 26 and remainder will be the convertedChar value
            }

            char convertedChar = (char) (currentChar + 'a'); // converts back number to a character
            encryptStr += convertedChar; // adds each character to encryptStr
        }

        // Print the plain text and encrypted text verson
        encryptStr = encryptStr.toUpperCase(); // sets all letters to uppercase
        System.out.println("Original Message: " + plainStr);
        System.out.println("Encrypted Message: " + encryptStr);

    }

}