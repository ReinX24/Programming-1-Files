import java.util.Scanner;

public class EscapeVelocity {

    public static void main(String[] args) {

        /*
         * Please enter your planet's name: Prometheus
         * Please enter your planet's mass in kg(M): 5.9723
         * Please enter your planet's radius in km (R): 63710
         * 
         */

        Scanner scanOne = new Scanner(System.in);
        float GRAVITY_CONSTANT = 6.674f; // gravity constant

        System.out.print("Please enter your planet's name: "); // asking for planet name
        String planetName = scanOne.nextLine();

        System.out.print("Please enter your planet's mass in kg(M): "); // asking for planet mass
        float planetMass = scanOne.nextFloat();

        System.out.print("Please enter your planet's radius in km (R): "); // asking for planet radius
        float planetRadius = scanOne.nextFloat();

        float escapeVelocity = (float) Math.sqrt(2 * GRAVITY_CONSTANT * planetMass / planetRadius); // velocity
        System.out.format("The speed needed to escape the planet " + planetName + " is: %.3f\n", escapeVelocity);

        scanOne.close(); // closing our Scanner object

    }

}