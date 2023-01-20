import java.util.Scanner;

public class VigenereEncoder {

    public static void main(String[] args) {

        /*
         * To test, try inputting the certain inputs in the program
         * Plain Text: SAVETHEQUEEN
         * Keyword: blade
         * 
         * Output should be:
         * TLVHXIPQXIFY
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Vigenere Cypher]");

        System.out.print("Enter plain text: ");
        String plainText = scanOne.nextLine();

        System.out.print("Enter keyword: ");
        String keywordString = scanOne.nextLine();

        keywordString = keywordString.toLowerCase(); // makes keywordString lowercase
        String encryptKey = ""; // where we will be storing our key for our plainText
        String encryptedText = ""; // storing encrypted message

        int keyStreamNum = 0; // used as an indicator for which index char the while loop is at for encryptKey
        int keyChar = 0; // index for keywordString, resets when reaches end of String
        while (keyStreamNum < plainText.length()) { // loop that adds keywordString repeatedly to encryptKey
            if (keyChar == keywordString.length()) { // if index is at end of keywordString, restart keyChar counter
                keyChar = 0; // resets keyChar number
            } else { // adds String normally
                encryptKey += keywordString.charAt(keyChar); // adds each character in encryptKey
                keyChar++;
                keyStreamNum++;
            }
        }

        String lowerPlainText = plainText.toLowerCase(); // makes a lowercase version of plainText
        for (int i = 0; i < lowerPlainText.length(); i++) { // loop that encrypts the plainText
            int charNum = lowerPlainText.charAt(i); // plainText char
            int charKeyNum = encryptKey.charAt(i); // char to be added to plainText
            charNum -= 'a'; // converting values to 0 - 25
            charKeyNum -= 'a';
            charNum += charKeyNum; // adds charKeyNum value
            if (charNum > 25) { // if the current charNum exceeds the alphabet
                charNum -= 26;
            }
            char addChar = (char) (charNum + 'a'); // converts charNum into a character and puts into addChar
            encryptedText += addChar; // adds char to encryptedText
        }
        encryptedText = encryptedText.toUpperCase(); // makes encryptedText uppercase
        System.out.printf("\n");
        System.out.printf("%20s : %S\n", "Plain Text", plainText);
        System.out.printf("%20s : %S\n", "Encrypted Text", encryptedText);
        System.out.printf("\n");
        scanOne.close(); // closes our Scanner object

    }

}