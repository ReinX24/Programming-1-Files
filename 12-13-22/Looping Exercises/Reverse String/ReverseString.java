/*
 * Author: Rein Aldwin E. Solis
 * Programming Language: Java
 * Creation Date: 12/23/22
 * School: Universidad De Dagupan
 * Description: Reverse String Exercise
 * 
 */

public class ReverseString {

    public static void main(String[] args) {
        
        /*
         * Reverse a String using a loop. Using arrays is prohibited
         * 
         */

        String myString = "Voltes"; // our original String
        String reversedString = ""; // where we will store our reversed String

        for (int i = myString.length() - 1; i >= 0; i--) { // for loop that will start at the end of String

            reversedString += myString.charAt(i); // adds each character, starting from the end, to reversedString
            // += is shorthand for reversedString = reversedString + myString.charAt(i);

        }

        System.out.println("Original String: " + myString);
        System.out.println("Reversed String: " + reversedString);

    }

}