import java.util.Scanner;

public class ShiftCypherBruteForce {

    public static void main(String[] args) {

        /*
         * Decoder for Shift Cypher but without the key, prints all possible messages
         * through all possible keys
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Shift Cypher Decoder Without Key]");
        System.out.print("Input encrypted message: ");
        String encryptionString = scanOne.nextLine();

        String lowerEncryptionString = encryptionString.toLowerCase();
        String plainText = "";

        for (int i = 1; i <= 26; i++) {
            for (int j = 0; j < lowerEncryptionString.length(); j++) {
                int charIndex = lowerEncryptionString.charAt(j);
                charIndex -= 'a';
                charIndex -= i;

                if (charIndex < 0) {
                    charIndex += 26;
                }

                char charConverted = (char) (charIndex + 'a');
                plainText += charConverted;
            }
            plainText = plainText.toUpperCase(); // sets all characters to uppercase
            System.out.println("Key " + i + ": " + plainText); // shows key and current decyphered message
            plainText = ""; // resets plainText for next key
        }

        scanOne.close(); // closes the Scanner object

    }

}
