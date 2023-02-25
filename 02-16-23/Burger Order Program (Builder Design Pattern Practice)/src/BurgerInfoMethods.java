public interface BurgerInfoMethods {

    /*
     * Method that executes the methods that asks the user information about their
     * burger
     */
    StringBuilder askBurgerInfo();

    /* Method that asks how much buns the user wants */
    void askBunAmount();

    /* Method that asks if the user wants 1 or more patties on their burger */
    void askPattyAmount();

    /* Method that asks if the user wants cheese on their burger or not */
    void askHasCheese();

    /* Method that asks if the user wants lettuce on their burger or not */
    void askHasLettuce();

    /* Method that asks if the user wants cucumber on their burger or not */
    void askHasCucumber();

    /* Method that asks if the user wants onions on their burger or not */
    void askHasOnions();

    /* Method that asks if the user wants ketchup on their burger or not */
    void askHasKetchup();

    /*
     * Method that asks how many burgers does the user want with the same attributes
     */
    void askBurgerAmount();

    /* Ask if dine in or take out */
    void askIfDineIn();

    /* Method that prints the totat cost of the order */
    void printTotal();

    /* Method that returns the total cost of the order */
    int getTotalCost();

}
