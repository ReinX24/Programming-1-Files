import java.util.Scanner;

public class EmpiricalDefinitionOfProbability {

    public static void main(String[] args) {

        /* Empirical Definition of Probability formula calculator */

        Scanner scanOne = new Scanner(System.in);

        System.out.println("[Empirical Definition of Probability Calculator]");
        System.out.println("Formula: P(E) = number of times E occured / number of times experiment was repeated");
        // P(E) means possibility of the event happening

        System.out.print("Enter the number of times E occured: ");
        float occurNum = scanOne.nextFloat();

        System.out.print("Enter the number of times the experiment was repeated: ");
        float repeatNum = scanOne.nextFloat();

        float PE = occurNum / repeatNum;
        System.out.printf("%s : %.0f%%\n", "The probability of one of the events occuring is", PE * 100);
        scanOne.close();

    }

}
