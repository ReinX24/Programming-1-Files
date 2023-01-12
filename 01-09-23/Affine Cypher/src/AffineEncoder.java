import java.util.Scanner;

public class AffineEncoder {

    public static void main(String[] args) {

        /*
         * Affine Cypher Encoder: Refer to Page 162 to 163 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        // Asking for String to Encode
        System.out.println("[Affine Cypher Encoder]");
        System.out.print("Input String to Encode: ");
        String userStr = scanOne.nextLine();
        // Asking for Keys
        System.out.print("Input First Key: "); // first key
        int keyOne = scanOne.nextInt();
        System.out.print("Input Second Key: "); // second key
        int keyTwo = scanOne.nextInt();

        String userStrLowerCase = userStr.toLowerCase(); // lowercase version of usrStr
        String encryptedString = ""; // where we will store encrypted String

        for (int i = 0; i < userStrLowerCase.length(); i++) { // loops through the String
            char charIndex = userStrLowerCase.charAt(i); // current char
            int charNum = charIndex - 'a'; // subtract 'a'(int equivalent) from charNum
            charNum = (keyOne * charNum + keyTwo) % 26; // perform Affine Cypher encoder formula
            char encryptedChar = (char) (charNum + 'a'); // converts number back to characters
            encryptedString += encryptedChar; // adds character to encryptedString
        }
        encryptedString = encryptedString.toUpperCase(); // makes encryptedString all uppercase letters
        System.out.println("Original String: " + userStr); // displays original String
        System.out.println("Encrypted String: " + encryptedString); // displays encrypted String
        scanOne.close(); // closes our Scanner object

    }

}