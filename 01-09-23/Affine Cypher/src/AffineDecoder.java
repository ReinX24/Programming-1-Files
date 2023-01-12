import java.util.Scanner;

public class AffineDecoder {

    public static void main(String[] args) {

        /*
         * Affine Cypher Decoder: Refer to Page 162 to 163 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        // Asking for String to Decode
        System.out.println("[Affine Cypher Decoder]");
        System.out.print("Input String to Decode: ");
        String userStr = scanOne.nextLine();
        // Asking for Keys
        System.out.print("Input First Key: "); // first key
        int keyOne = scanOne.nextInt();
        System.out.print("Input Second Key: "); // second key
        int keyTwo = scanOne.nextInt();

        String userStrLowerCase = userStr.toLowerCase(); // lowercase version of usrStr
        String decryptedString = ""; // where we will store decrypted String

        for (int i = 0; i < userStrLowerCase.length(); i++) { // loops through the String
            char charIndex = userStrLowerCase.charAt(i); // current char
            int charNum = charIndex - 'a'; // subtract 'a'(int equivalent) from charNum
            // Calculating for multiplicative inverse of keyOne
            // Link: https://www.geeksforgeeks.org/implementation-affine-cipher/
            int flagOne = 0;
            int multiplicativeInverse = 0;
            for (int j = 0; j < 26; j++) {
                flagOne = (keyOne * j) % 26;
                if (flagOne == 1) {
                    multiplicativeInverse = j;
                }
            }
            charNum = (multiplicativeInverse * (charNum - keyTwo)) % 26; // perform Affine Cypher decoder formula
            char encryptedChar = (char) (charNum + 'a'); // converts number back to characters
            decryptedString += encryptedChar; // adds character to decryptedString
        }
        decryptedString = decryptedString.toUpperCase(); // makes decryptedString all uppercase letters
        System.out.println("Original String: " + userStr); // displays original String
        System.out.println("Encrypted String: " + decryptedString); // displays encrypted String
        scanOne.close(); // closes our Scanner object

    }

}
