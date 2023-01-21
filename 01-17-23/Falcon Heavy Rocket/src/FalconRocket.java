import java.util.Scanner;

public class FalconRocket {

    public static void main(String[] args) {

        /*
         * Solution for a Programming Activity for a friend in Univerisity of
         * Pangasinan (UPANG).
         * 
         */

        // Title
        System.out.println("Falcon 9|Heavy Rocket Data");
        Scanner myInput = new Scanner(System.in); // Scanner object to accept input
        // ve
        System.out.print("Please enter rocket exhaust velocity in km/s(ve): ");
        float ve = myInput.nextFloat();
        // Ae
        System.out.print("Please enter rocket nozzle flow in m2 (Ae): ");
        float Ae = myInput.nextFloat();
        // dm
        System.out.print("Please enter mass expelled from the rocket in kg per engine (dm): ");
        float dm = myInput.nextFloat();
        // dt
        System.out.print("Please enter time elapsed for mass expelled ins seconds (dt): ");
        float dt = myInput.nextFloat();
        // Pamb
        System.out.print("Please enter Ambient Pressure in pascals (Pamb): ");
        float Pamb = myInput.nextFloat();
        // Pe
        System.out.print("Please enter Static Pressure in pascals (Pe): ");
        float Pe = myInput.nextFloat();
        // mathemagics
        float rocket = ve * (dm / dt) + Ae * (Pe - Pamb);
        // final
        System.out.printf("The rocket propulsion needed to lift the rocket is: %.0f kN\n", rocket);
        myInput.close(); // closing our Scanner object
    }

}
