public interface BurgerInfoMethods {

    /*
     * Method that executes the methods that asks the user information about their
     * burger
     */
    StringBuilder askBurgerInfo();

    /* Method that asks how much buns the user wants */
    int askBunAmount();

    /* Method that asks if the user wants 1 or more patties on their burger */
    int askPattyAmount();

    /* Method that asks if the user wants cheese on their burger or not */
    boolean askHasCheese();

    /* Method that asks if the user wants lettuce on their burger or not */
    boolean askHasLettuce();

    /* Method that asks if the user wants cucumber on their burger or not */
    boolean askHasCucumber();

    /* Method that asks if the user wants onions on their burger or not */
    boolean askHasOnions();

    /* Method that asks if the user wants ketchup on their burger or not */
    boolean askHasKetchup();

    /*
     * Method that asks how many burgers does the user want with the same attributes
     */
    int askBurgerAmount();

    /* Ask if dine in or take out */
    boolean askIfDineIn();

    /* Method that prints the totat cost of the order */
    void printTotal();

    /* Method that returns the total cost of the order */
    int getTotalCost();

}
