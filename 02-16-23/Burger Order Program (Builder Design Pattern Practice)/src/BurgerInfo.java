import java.util.Scanner;

public class BurgerInfo implements BurgerInfoMethods {

    Scanner userInput = new Scanner(System.in);
    String customerName;
    int orderTotalCost;
    int pattyAmount;
    boolean hasCheese;
    boolean hasLettuce;
    boolean hasCucumber;
    boolean hasOnions;
    boolean hasKetchup;

    public BurgerInfo(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public StringBuilder askBurgerInfo() {
        StringBuilder burgerReceipt = new StringBuilder();
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
        burgerReceipt.append("[Total Cost: " + this.orderTotalCost + "]\n");
        return burgerReceipt;
    }

    @Override
    public int askPattyAmount() {
        System.out.print("How much patties do you want for your burger? [P15 per piece] : ");
        int pattyAmount = userInput.nextInt();
        this.orderTotalCost = this.pattyAmount * 15;
        return pattyAmount;
    }

    @Override
    public boolean askHasCheese() {
        System.out.print("Do you want cheese on your burger? [P5 for add on] : ");
        char userChoice = userInput.next().charAt(0);
        boolean hasCheese;
        if (Character.toLowerCase(userChoice) == 'y') {
            this.orderTotalCost += 5;
            hasCheese = true;
        } else {
            hasCheese = false;
        }
        return hasCheese;
    }

    @Override
    public boolean askHasLettuce() {
        System.out.print("Do you want lettuce on your burger? [P8 for add on] : ");
        boolean hasLettuce = userInput.nextBoolean();
        if (hasLettuce) {
            this.orderTotalCost += 8;
        }
        return hasLettuce;
    }

    @Override
    public boolean askHasCucumber() {
        System.out.print("Do you want cucumber on your burger? [P7 for add on] : ");
        boolean hasCucumber = userInput.nextBoolean();
        if (hasCucumber) {
            this.orderTotalCost += 7;
        }
        return hasCucumber;
    }

    @Override
    public boolean askHasOnions() {
        System.out.print("Do you want onions on your burger? [P5 for add on] : ");
        boolean hasOnions = userInput.nextBoolean();
        if (hasOnions) {
            this.orderTotalCost += 5;
        }
        return hasOnions;
    }

    @Override
    public boolean askHasKetchup() {
        System.out.print("Do you want ketchup on your burger? [P6 for add on] : ");
        boolean hasKetchup = userInput.nextBoolean();
        if (hasKetchup) {
            this.orderTotalCost += 6;
        }
        return hasKetchup;
    }

}
