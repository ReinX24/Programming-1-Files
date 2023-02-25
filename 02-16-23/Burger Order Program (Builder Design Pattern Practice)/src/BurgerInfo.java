import java.util.Scanner;

public class BurgerInfo implements BurgerInfoMethods {

    Scanner userInput = new Scanner(System.in);
    String customerName;
    int orderTotalCost;
    /* Stores ingredients' information */
    int bunBurgerAmount;
    int pattyBurgerAmount;
    boolean hasCheese;
    boolean hasLettuce;
    boolean hasCucumber;
    boolean hasOnions;
    boolean hasKetchup;
    int burgerAmount;
    boolean dineIn;
    /* Prices of each ingredient */
    final int BUN_PRICE = 10;
    final int PATTY_PRICE = 20;
    final int CHEESE_PRICE = 5;
    final int LETTUCE_PRICE = 8;
    final int CUCUMBER_PRICE = 7;
    final int ONION_PRICE = 5;
    final int KETCHUP_PRICE = 6;
    /* Price add on for take-out */
    final int TAKEOUT_PRICE = 5;
    /* Variable that serves as the serial number for the order */
    /*
     * We will be using a static variable since it will record any modifications to
     * it for each object. This means that this variable's value will not be
     * resetted when we create a new object.
     */
    static int serialNumberOrder = 0;
    /* Boolean that will loop method if there is an error */
    boolean errorExist;

    public BurgerInfo(String customerName) {
        this.customerName = customerName;
    }

    public StringBuilder askBurgerInfo() {
        StringBuilder burgerReceipt = new StringBuilder();
        burgerReceipt.append("\n-------------------------\n");
        burgerReceipt.append("[Order Receipt\t: " + serialNumberOrder + "\t]\n");
        burgerReceipt.append("-------------------------\n");
        /* Adding the customerName to the receipt */
        burgerReceipt.append("\n[Customer Name\t: " + this.customerName + "\t]\n");
        /* Asking for bun amount and recording in receipt */
        askBunAmount();
        burgerReceipt.append("[Bun Amount\t: " + this.bunBurgerAmount + "\t]\n");
        /* Asking for patty amount and recording in receipt */
        askPattyAmount();
        burgerReceipt.append("[Patty Amount\t: " + this.pattyBurgerAmount + "\t]\n");
        /* Asking if the burger has cheese and recording in receipt */
        askHasCheese();
        burgerReceipt.append("[Has Cheese\t: " + this.hasCheese + "\t]\n");
        /* Asking if the burger has lettuce and recording in receipt */
        askHasLettuce();
        burgerReceipt.append("[Has Lettuce\t: " + this.hasLettuce + "\t]\n");
        /* Asking if the burger has cucumber and recording in receipt */
        this.hasCucumber = askHasCucumber();
        burgerReceipt.append("[Has Cucumber\t: " + this.hasCucumber + "\t]\n");
        /* Asking if the burger has onions and recording in receipt */
        this.hasOnions = askHasOnions();
        burgerReceipt.append("[Has Onions\t: " + this.hasOnions + "\t]\n");
        /* Asking if the burger has ketchup and recording in receipt */
        this.hasKetchup = askHasKetchup();
        burgerReceipt.append("[Has Ketchup\t: " + this.hasKetchup + "\t]\n");
        /* Asking how many burgers does the customer want with the same attributes */
        this.burgerAmount = askBurgerAmount();
        /* Records amount of burgers ordered in receipt */
        burgerReceipt.append("[Burger Amount\t: " + this.burgerAmount + "\t]\n");
        burgerReceipt.append("\n[Total Cost\t: " + this.orderTotalCost + "\t]\n");
        /* Asking if the order is dine in or take out and record in receipt */
        this.dineIn = askIfDineIn();
        burgerReceipt.append("[Dine in\t: " + this.dineIn + "\t]\n");
        burgerReceipt.append("\n-------------------------\n");
        serialNumberOrder++;
        return burgerReceipt;
    }

    // TODO: Manually test different cases for creating a burger
    public void askBunAmount() {
        do {
            System.out.print("\nAmount of buns for burger?           [P10 per piece] : ");
            if (userInput.hasNextInt()) {
                int bunAmount = userInput.nextInt();
                /* If the burger has 0 buns */
                if (bunAmount == 0) {
                    System.out.println("[Burger Has No Buns!]");
                    askBunAmount();
                } else if (bunAmount > 1) {
                    System.out
                            .println(bunAmount + " buns ordered! P" + bunAmount * BUN_PRICE + " added to total cost.");
                } else {
                    System.out.println(bunAmount + " bun ordered! P" + bunAmount * BUN_PRICE + " added to total cost.");
                }
                this.orderTotalCost += bunAmount * BUN_PRICE;
                printTotal();
                this.bunBurgerAmount = bunAmount;
                this.errorExist = false;
            } else {
                this.errorExist = true;
                userInput.next();
                System.out.println("\n[Invalid Input Detected!]");
                continue;
            }
        } while (errorExist);
    }

    public void askPattyAmount() {
        do {
            System.out.print("\nAmount of patties for burger?        [P20 per piece] : ");
            if (userInput.hasNextInt()) {
                int pattyAmount = userInput.nextInt();
                /* If the burger has 0 patties */
                if (pattyAmount <= 0) {
                    System.out.println("[Burger Has No Patties!]");
                    askPattyAmount();
                } else if (pattyAmount > 1) {
                    System.out
                            .println(pattyAmount + " patties ordered! P" + pattyAmount * PATTY_PRICE
                                    + " added to total cost.");
                } else {
                    System.out.println(
                            pattyAmount + " patty ordered! P" + pattyAmount * PATTY_PRICE + " added to total cost.");
                }
                this.orderTotalCost += pattyAmount * PATTY_PRICE;
                printTotal();
                this.pattyBurgerAmount = pattyAmount;
                this.errorExist = false;
            } else {
                this.errorExist = true;
                userInput.next(); // just next for int
                System.out.println("\n[Invalid Input Detected!]");
                continue;
            }
        } while (errorExist);
    }

    public void askHasCheese() {
        // ! Needs to misinput 2 times to trigger error message
        do {
            System.out.print("\nDo you want cheese on your burger?   [y/n] [P5 for add on] : ");
            char userChoice = userInput.next().charAt(0);
            if (Character.toLowerCase(userChoice) == 'y') {
                System.out.println("Cheese added to burger! P5 added to total cost.");
                this.orderTotalCost += CHEESE_PRICE;
                this.hasCheese = true;
                this.errorExist = false;
            } else if (Character.toLowerCase(userChoice) == 'n') {
                this.hasCheese = false;
                this.errorExist = false;
            } else {
                this.errorExist = true;
                userInput.nextLine(); // nextLine for char
                System.out.println("\n[Invalid Input Detected!]");
                continue;
            }
        } while (errorExist);
        printTotal();
    }

    // TODO: Test askHasLettuce
    public void askHasLettuce() {
        System.out.print("\nDo you want lettuce on your burger?  [y/n] [P8 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        do {
            if (Character.toLowerCase(userChoice) == 'y') {
                System.out.println("Lettuce added to burger! P8 added to total cost.");
                this.orderTotalCost += LETTUCE_PRICE;
                this.hasLettuce = true;
                this.errorExist = false;
            } else if (Character.toLowerCase(userChoice) == 'n') {
                this.hasLettuce = false;
                this.errorExist = false;
            } else {
                this.errorExist = true;
                userInput.nextLine();
                System.out.println("\n[Invalid Input Detected!]");
                continue;
            }
        } while (errorExist);
        printTotal();
    }

    public boolean askHasCucumber() {
        System.out.print("\nDo you want cucumber on your burger? [y/n] [P7 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Cucumber added to burger! P7 added to total cost.");
            this.orderTotalCost += CUCUMBER_PRICE;
            printTotal();
            return true;
        }
        printTotal();
        return false;
    }

    public boolean askHasOnions() {
        System.out.print("\nDo you want onions on your burger?   [y/n] [P5 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Onions added to burger! P5 added to total cost.");
            this.orderTotalCost += ONION_PRICE;
            printTotal();
            return true;
        }
        printTotal();
        return false;
    }

    public boolean askHasKetchup() {
        System.out.print("\nDo you want ketchup on your burger?  [y/n] [P6 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Ketchup added to burger! P6 added to total cost.");
            this.orderTotalCost += KETCHUP_PRICE;
            printTotal();
            return true;
        }
        printTotal();
        return false;
    }

    public int askBurgerAmount() {
        System.out.print("\nAmount of burgers for order?         [Max of 5] : ");
        int burgerAmount = userInput.nextInt();
        while (burgerAmount > 5) {
            System.out.println("[You can only order a maximum of 5 burgers!]");
            System.out.print("Amount of burgers for order?         [Max of 5] : ");
            burgerAmount = userInput.nextInt();
        }
        System.out.println("Ordered a total of " + burgerAmount + " burgers.");
        this.orderTotalCost *= burgerAmount;
        printTotal();
        return burgerAmount;

    }

    public boolean askIfDineIn() {
        System.out.print("\nWill you be dining in?               [y/n] [P5 for take out] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            printTotal();
            return true;
        }
        System.out.println("Take out chosen, P5 added to toal cost.");
        this.orderTotalCost += TAKEOUT_PRICE;
        printTotal();
        return false;
    }

    public void printTotal() {
        System.out.println("\n[Current Total Cost : P" + this.orderTotalCost + "]");
    }

    public int getTotalCost() {
        return this.orderTotalCost;
    }

}
