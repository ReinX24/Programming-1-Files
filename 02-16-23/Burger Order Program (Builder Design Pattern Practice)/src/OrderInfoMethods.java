public interface OrderInfoMethods {

    /* Method that asks and checks the input of the user */
    void askIfOrder();

    /* Method that asks if the user wants to order a burger or not */
    void askConfirm();

    /* Method that checks the user input */
    void checkInput();

    /* Method that asks the customer for their name and creates an object */
    void askCustomerName();

    /* Method that creates a BurgerInfo object with the customerName */
    void createOrder(String customerName);

}
