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

    public BurgerInfo(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public StringBuilder askBurgerInfo() {
        StringBuilder burgerReceipt = new StringBuilder();
        burgerReceipt.append("\n------------------------\n");
        burgerReceipt.append("[Order Receipt]\n");
        burgerReceipt.append("------------------------\n");
        burgerReceipt.append("\n[Customer Name: " + this.customerName + "]\n");
        this.bunAmount = askBunAmount();
        burgerReceipt.append("[Bun Amount: " + this.bunAmount + "]\n");
        this.pattyAmount = askPattyAmount();
        burgerReceipt.append("[Patty Amount: " + this.pattyAmount + "]\n");
        this.hasCheese = askHasCheese();
        burgerReceipt.append("[Has Cheese: " + this.hasCheese + "]\n");
        this.hasLettuce = askHasLettuce();
        burgerReceipt.append("[Has Lettuce: " + this.hasLettuce + "]\n");
        this.hasCucumber = askHasCucumber();
        burgerReceipt.append("[Has Cucumber: " + this.hasCucumber + "]\n");
        this.hasOnions = askHasOnions();
        burgerReceipt.append("[Has Onions: " + this.hasOnions + "]\n");
        this.hasKetchup = askHasKetchup();
        burgerReceipt.append("[Has Ketchup: " + this.hasKetchup + "]\n");
        this.burgerAmount = askBurgerAmount();
        burgerReceipt.append("[Amount of Burgers: " + this.burgerAmount + "]\n");
        burgerReceipt.append("\n[Total Cost: " + this.orderTotalCost + "]\n");
        burgerReceipt.append("\n------------------------\n");
        userInput.close();
        return burgerReceipt;
    }

    @Override
    public int askBunAmount() {
        System.out.print("Amount of buns for burger?           [P10 per piece] : ");
        int bunAmount = userInput.nextInt();
        this.orderTotalCost += bunAmount * 10;
        return bunAmount;
    }

    @Override
    public int askPattyAmount() {
        System.out.print("Amount of patties for burger?        [P20 per piece] : ");
        int pattyAmount = userInput.nextInt();
        this.orderTotalCost += pattyAmount * 20;
        return pattyAmount;
    }

    @Override
    public boolean askHasCheese() {
        System.out.print("Do you want cheese on your burger?   [y/n] [P5 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
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
            this.orderTotalCost += 6;
            return true;
        }
        return false;
    }

    @Override
    public int askBurgerAmount() {
        System.out.print("Amount of burgers for order?         [Max of 5] : ");
        int burgerAmount = userInput.nextInt();
        if (burgerAmount >= 5) {
            // TODO: Debug askBurgerAmount method
            askBurgerAmount();
        }
        this.orderTotalCost += burgerAmount * this.orderTotalCost;
        return burgerAmount;

    }

}
