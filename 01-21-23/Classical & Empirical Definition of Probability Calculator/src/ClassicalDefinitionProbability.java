import java.util.Scanner;

public class ClassicalDefinitionProbability {

    public static void main(String[] args) {

        /*
         * Classical Definition of Probability: Refer to Page 190 of Essential
         * Mathematics in the Modern World by Rizaldi C. Nocon & Ederlina G. Nocon
         * 
         */

        /* Classical Definition of Probability formula calculator */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Classical Definition of Probability Calculator]");
        System.out.println("Formula: P(E) = n / N"); // P(E) means possibility of the event happening

        System.out.print("Enter n: "); // asking for n
        float n = scanOne.nextFloat();

        System.out.print("Enter N: "); // asking for N
        float N = scanOne.nextFloat();

        float PE = n / N; // calculates the possibility of one of the events (n) happening
        System.out.printf("%s : %.0f%%\n", "The probability of one of the events occuring is", PE * 100);

        scanOne.close(); // closing our Scanner object

    }

}