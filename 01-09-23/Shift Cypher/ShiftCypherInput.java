import java.util.Scanner;

public class ShiftCypherInput {

    public static void main(String[] args) {

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
            // if (charIndex > 25) {
            //     charIndex -= 122;
            //     System.out.println(charIndex);
            // }

            charIndex += 3;
            char charConverted = (char) (charIndex + 'a');
            encryptedString += charConverted;
        }

        encryptedString = encryptedString.toUpperCase();
        System.out.println("Original Message: " + plainString);
        System.out.println("Encrypted Message: " + encryptedString);
        scanOne.close();

    }

}