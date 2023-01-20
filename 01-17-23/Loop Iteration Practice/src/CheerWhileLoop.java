public class CheerWhileLoop {

    public static void main(String[] args) {
        
        /*
         * Print:
         * "2, 4, 6, 8, Who do we appreciate?"
         * in the terminal using a while loop
         */

        int startNum = 2;
        while (startNum < 10) {
            System.out.print(startNum + ", ");
            startNum += 2; // adds 2 to startNum
        }
        System.out.println("Who do we appreciate?");

    }

}