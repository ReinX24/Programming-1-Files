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

}
