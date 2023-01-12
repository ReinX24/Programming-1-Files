import java.util.Scanner;

public class ShiftCypherInput {

    public static void main(String[] args) {

        /*
         * Shift Cypher Encoder: Refer to Page 159 to 160 of Essential Mathematics in
         * the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Shift Cypher Program]");
        System.out.print("Input message: ");
        String plainString = scanOne.nextLine();
        System.out.print("Input key (shift amount): ");
        int keyNum = scanOne.nextInt();

        String lowerPlainString = plainString.toLowerCase();
        String encryptedString = "";

        for (int i = 0; i < lowerPlainString.length(); i++) {
            int charIndex = lowerPlainString.charAt(i);
            charIndex -= 'a';
            charIndex += keyNum;

            if (charIndex >= 26) {
                charIndex -= 26;
            }

            char charConverted = (char) (charIndex + 'a');
            encryptedString += charConverted;
        }

        encryptedString = encryptedString.toUpperCase();
        System.out.println("Original Message: " + plainString);
        System.out.println("Encrypted Message: " + encryptedString);
        scanOne.close();

    }

}