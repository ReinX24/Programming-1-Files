public class VigenereEncoder {

    public static void main(String[] args) {

        String plainText = "SAVETHEQUEEN";
        String keywordString = "blade";
        String encryptKey = ""; // where we will be storing our key for our plainText
        String cypherText = ""; // storing encrypted message

        int keyStreamNum = 0;
        int keyChar = 0;
        while (keyStreamNum < plainText.length()) {
            if (keyChar == keywordString.length()) {
                keyChar = 0; // resets keyChar number
            } else {
                encryptKey += keywordString.charAt(keyChar);
                keyChar++;
                keyStreamNum++;
            }
        }

        String lowerPlainText = plainText.toLowerCase();
        for (int i = 0; i < lowerPlainText.length(); i++) {
            int charNum = lowerPlainText.charAt(i);
            int charKeyNum = encryptKey.charAt(i);
            charNum -= 'a';
            charKeyNum -= 'a';
            charNum += charKeyNum;
            if (charNum > 25) {
                charNum -= 26;
            }
            char addChar = (char) (charNum + 'a');
            cypherText += addChar;
        }
        System.out.println(cypherText);

    }

}