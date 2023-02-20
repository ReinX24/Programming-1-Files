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

        OrderInfo askIfOrder = new OrderInfo();
        askIfOrder.askIfOrder();

    }

}