import java.util.Scanner;

public class VigenereDecoder {

    public static void main(String[] args) {

        /*
         * Vigenere Cypher Encoder: Refer to Page 163 to 164 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         * To test, try inputting the certain inputs in the program
         * Encrypted Text: TLVHXIPQXIFY
         * Keyword: blade
         * 
         * Output should be:
         * SAVETHEQUEEN
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Vigenere Cypher Decoder]");

        System.out.print("Enter encrypted text: ");
        String encryptedText = scanOne.nextLine();

        System.out.print("Enter keyword: ");
        String keywordString = scanOne.nextLine();

        keywordString = keywordString.toLowerCase(); // makes keywordString lowecase
        String decryptKey = ""; // storing our key for our encryptedText
        String decryptedText = ""; // storing our decryptedText

        int keyStreamNum = 0; // number for making sure the decryptKey is the same length as encryptedText
        int keyCharNum = 0; // number for index when iterating through keywordString

        while (keyStreamNum < encryptedText.length()) { // loops until keyStreamNum has the length of encryptedText
            if (keyCharNum == keywordString.length()) { // if keyCharNum exceeds the keywordString indexes, reset to 0
                keyCharNum = 0;
            } else { // adds each character in keywordString repeatedly until while loop is broken
                decryptKey += keywordString.charAt(keyCharNum); // adds current character to decryptKey
                keyCharNum++; // increments keyCharNum
                keyStreamNum++; // increments keyStreamNum
            }
        }

        String lowerEncryptedText = encryptedText.toLowerCase(); // stores lowecase version of encryptedText

        for (int i = 0; i < lowerEncryptedText.length(); i++) { // for loop that iterates through lowerEncryptedText
            int charNum = lowerEncryptedText.charAt(i); // iterating through encryptedText
            int keyNum = decryptKey.charAt(i); // iterating through our decryptKey
            charNum -= 'a';
            keyNum -= 'a';
            charNum -= keyNum;
            if (charNum < 0) {
                charNum += 26;
            }
            char addChar = (char) (charNum + 'a');
            decryptedText += addChar; // add decrypted character
        }

        decryptedText = decryptedText.toUpperCase(); // makes decryptedText uppercase
        System.out.printf("\n");
        System.out.printf("%20s : %s\n", "Encrypted Text", encryptedText); // print encryptedText
        System.out.printf("%20s : %s\n", "Decrypted Text", decryptedText); // print decryptedText
        System.out.printf("\n");
        scanOne.close(); // closing our Scanner object

    }

}
