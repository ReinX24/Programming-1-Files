public interface OrderInfoMethods {

    /* Method that asks and checks the input of the user */
    void askIfOrder();

    /* Method that asks if the user wants to order a burger or not */
    void askIfOrderConfirm();

    /* Method that checks the user input */
    void checkInput();

    /* Method that asks the customer for their name and creates an object */
    void askCustomerName();

    /* Method that creates a BurgerInfo object with the customerName */
    void createOrder(String customerName);

    /* Method that asks the user if they want to confirm their order */
    void askUserOrderConfirmation();

    /* Method that asks the user if they want to order another burger */
    void askUserOrderAgain();

    /* Method that asks for payment */
    void askOrderPayment();

}
