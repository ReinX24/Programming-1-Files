public class InitiateOrder {

    public static void main(String[] args) {

        /*
         * This will serve as the main class of the program, it will start by asking the
         * user if they want to order a burger and the program will go on if they choose
         * to order a burger.
         * 
         * This program will use the Builder Design Pattern where an object will be made
         * and the user will be prompted to specify attributes that they want for that
         * object.
         * 
         * In this case, we will be asking the user if they want a burger and will then
         * ask them for any additional information regarding the different ingredients
         * that could be inserted in the burger.
         */

        /*
         * 2/23/23 Note: Do not close your Scanner object in a class if other classes
         * are still going to use the Scanner class. Closing the Scanner class of one
         * class throws an exception when using the Scanner class in another class AFTER
         * closing the Scanner class.
         */

        /*
         * 2/24/23 The last major feature that will be added is that we will probably implement
         * try catch methods within our program. This will probably be the last project
         * that I will add to this repository and future commits will probably be just
         * fixing the pre-existing code in this repository.
         */

        OrderInfo askIfOrder = new OrderInfo();
        askIfOrder.askIfOrder();

    }

}