public class PrintEachCharString {

    public static void main(String[] args) {
        
        /*
         * Print each character in a String using a for loop
         * 
         */

        String strOne = "Voltes"; // our String variable
        for (int i = 0; i < strOne.length(); i++) {
            System.out.println(strOne.charAt(i)); // prints current iterated character
        }

    }
    
}
