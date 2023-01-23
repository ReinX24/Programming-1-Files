public class SummationGeena {

    public static void main(String[] args) {

        int a = 50;
        int k = 1;
        int summationResult = 0;
        /* a1 & a50 */
        System.out.println("a1 = 3(1) + 2 = " + (3 * (k) + 2));
        System.out.println("a50 = 3(50) + 2 = " + (3 * (a) + 2));
        /* Calculating for the sum */
        summationResult = a * ((3 * (k) + 2) + (3 * (a) + 2)) / 2;
        /* Printing the sum */
        System.out.println("Sum: " + summationResult);

    }

}