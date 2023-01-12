import java.util.Scanner;

public class ShiftCypherDecoderWithKey {

    public static void main(String[] args) {

        /*
         * Shift Cypher Decoder: Refer to Page 159 to 160 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        System.out.println("[Shift Cypher Decoder With Key]");
        System.out.print("Input encrypted message: ");
        String encryptionString = scanOne.nextLine();
        System.out.print("Input encryption key: ");
        int encryptionKey = scanOne.nextInt();

        String lowerEncryptionString = encryptionString.toLowerCase();
        String plainText = "";

        for (int i = 0; i < lowerEncryptionString.length(); i++) {
            int charIndex = lowerEncryptionString.charAt(i);
            charIndex -= 'a';
            charIndex -= encryptionKey;

            if (charIndex < 0) {
                charIndex += 26;
            }

            char charConverted = (char) (charIndex + 'a');
            plainText += charConverted;
        }

        plainText = plainText.toUpperCase();
        System.out.println("Encrypted message: " + encryptionString);
        System.out.println("Decrypted message: " + plainText);
        scanOne.close();

    }

}
