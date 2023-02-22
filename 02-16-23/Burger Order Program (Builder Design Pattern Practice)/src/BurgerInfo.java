import java.util.Scanner;

public class BurgerInfo implements BurgerInfoMethods {

    Scanner userInput = new Scanner(System.in);
    String customerName;
    int orderTotalCost;
    int bunAmount;
    int pattyAmount;
    boolean hasCheese;
    boolean hasLettuce;
    boolean hasCucumber;
    boolean hasOnions;
    boolean hasKetchup;
    int burgerAmount;
    boolean dineIn;

    public BurgerInfo(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public StringBuilder askBurgerInfo() {
        StringBuilder burgerReceipt = new StringBuilder();
        burgerReceipt.append("\n------------------------\n");
        burgerReceipt.append("[Order Receipt]\n");
        burgerReceipt.append("------------------------\n");
        /* Adding the customerName to the receipt */
        burgerReceipt.append("\n[Customer Name: " + this.customerName + "]\n");
        /* Asking for bun amount and recording in receipt */
        this.bunAmount = askBunAmount();
        burgerReceipt.append("[Bun Amount: " + this.bunAmount + "]\n");
        /* Asking for patty amount and recording in receipt */
        this.pattyAmount = askPattyAmount();
        burgerReceipt.append("[Patty Amount: " + this.pattyAmount + "]\n");
        /* Asking if the burger has cheese and recording in receipt */
        this.hasCheese = askHasCheese();
        burgerReceipt.append("[Has Cheese: " + this.hasCheese + "]\n");
        /* Asking if the burger has lettuce and recording in receipt */
        this.hasLettuce = askHasLettuce();
        burgerReceipt.append("[Has Lettuce: " + this.hasLettuce + "]\n");
        /* Asking if the burger has cucumber and recording in receipt */
        this.hasCucumber = askHasCucumber();
        burgerReceipt.append("[Has Cucumber: " + this.hasCucumber + "]\n");
        /* Asking if the burger has onions and recording in receipt */
        this.hasOnions = askHasOnions();
        burgerReceipt.append("[Has Onions: " + this.hasOnions + "]\n");
        /* Asking if the burger has ketchup and recording in receipt */
        this.hasKetchup = askHasKetchup();
        burgerReceipt.append("[Has Ketchup: " + this.hasKetchup + "]\n");
        /* Asking how many burgers does the customer want with the same attributes */
        this.burgerAmount = askBurgerAmount();
        /* Records amount of burgers ordered in receipt */
        burgerReceipt.append("[Amount of Burgers: " + this.burgerAmount + "]\n");
        burgerReceipt.append("\n[Total Cost: " + this.orderTotalCost + "]\n");
        /* Asking if the order is dine in or take out and record in receipt */
        this.dineIn = askIfDineIn();
        burgerReceipt.append("[Dine in: " + this.dineIn + "]\n");
        burgerReceipt.append("\n------------------------\n");
        userInput.close();
        return burgerReceipt;
    }

    // TODO: Manually test different cases for creating a burger
    // TODO: Put each ingredient amount in their own final in variables
    @Override
    public int askBunAmount() {
        System.out.print("Amount of buns for burger?           [P10 per piece] : ");
        int bunAmount = userInput.nextInt();
        if (bunAmount > 1) {
            System.out.println(bunAmount + " buns ordered! P" + bunAmount * 10 + " added to total cost.");
        } else {
            System.out.println(bunAmount + " bun ordered! P" + bunAmount * 10 + " added to total cost.");
        }
        // TODO: add error message that says the burger cannot have 0 buns
        this.orderTotalCost += bunAmount * 10;
        return bunAmount;
    }

    @Override
    public int askPattyAmount() {
        System.out.print("Amount of patties for burger?        [P20 per piece] : ");
        int pattyAmount = userInput.nextInt();
        if (pattyAmount > 1) {
            System.out.println(pattyAmount + " patties ordered! P" + pattyAmount * 20 + " added to total cost.");
        } else {
            System.out.println(pattyAmount + " patty ordered! P" + pattyAmount * 20 + " added to total cost.");
        }
        // TODO: add error message that says the burger cannot have 0 patties
        this.orderTotalCost += pattyAmount * 20;
        return pattyAmount;
    }

    @Override
    public boolean askHasCheese() {
        System.out.print("Do you want cheese on your burger?   [y/n] [P5 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Cheese added to burger! P5 added to total cost.");
            this.orderTotalCost += 5;
            return true;
        }
        return false;
    }

    @Override
    public boolean askHasLettuce() {
        System.out.print("Do you want lettuce on your burger?  [y/n] [P8 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Lettuce added to burger! P8 added to total cost.");
            this.orderTotalCost += 8;
            return true;
        }
        return false;
    }

    @Override
    public boolean askHasCucumber() {
        System.out.print("Do you want cucumber on your burger? [y/n] [P7 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Cucumber added to burger! P7 added to total cost.");
            this.orderTotalCost += 7;
            return true;
        }
        return false;
    }

    @Override
    public boolean askHasOnions() {
        System.out.print("Do you want onions on your burger?   [y/n] [P5 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Onions added to burger! P5 added to total cost.");
            this.orderTotalCost += 5;
            return true;
        }
        return false;
    }

    @Override
    public boolean askHasKetchup() {
        System.out.print("Do you want ketchup on your burger?  [y/n] [P6 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("Ketchup added to burger! P6 added to total cost.");
            this.orderTotalCost += 6;
            return true;
        }
        return false;
    }

    @Override
    public int askBurgerAmount() {
        System.out.print("Amount of burgers for order?         [Max of 5] : ");
        int burgerAmount = userInput.nextInt();
        while (burgerAmount > 5) {
            System.out.println("[You can only order a maximum of 5 burgers!]");
            System.out.print("Amount of burgers for order?         [Max of 5] : ");
            burgerAmount = userInput.nextInt();
        }
        System.out.println("Ordered a total of " + burgerAmount + " burgers.");
        this.orderTotalCost *= burgerAmount;
        return burgerAmount;

    }

    @Override
    public boolean askIfDineIn() {
        System.out.print("Will you be dining in?               [y/n] [P5 for take out] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            return true;
        }
        System.out.println("Take out chosen, P5 added to toal cost.");
        this.orderTotalCost += 5;
        return false;
    }

}
