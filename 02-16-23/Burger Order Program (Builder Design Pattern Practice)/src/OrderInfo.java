import java.util.Scanner;

public class OrderInfo implements OrderInfoMethods {

    Scanner userInput = new Scanner(System.in);
    char userChoice;
    String customerName;
    StringBuilder orderReceipt;

    public void askIfOrder() {

        /* Ask the user if they want to order a burder */
        askConfirm();
        /* If y, confirm order, create a burgerInfo object, & execute askInfo method */
        checkInput();
        /* Asks the user for their customer name */
        askCustomerName();
        /* Creates an order with the name of the user */
        createOrder(customerName);
        /* Prints orderReceipt */
        printReceipt();
        /* Closes userInput Scanner object */
        userInput.close();

    }

    public void askConfirm() {
        System.out.printf("\n%50s\n\n", "[Burger Order Program]");
        System.out.print("Do you want to order a burger? [y/n] : ");
        this.userChoice = userInput.next().charAt(0);
        userInput.nextLine();
    }

    public void checkInput() {
        if (Character.toLowerCase(this.userChoice) == 'y') {
            /* Print confirmation message & ask for userName */
            System.out.println("\n[Confirmed!]\n");
        } else if (Character.toLowerCase(this.userChoice) == 'n') {
            /* Cancels order & terminates program */
            System.out.println("\n[Cancelled!]\n");
            userInput.close();
            return;
        } else {
            /* If the userChoice in invalid */
            System.out.println("\n[Invalid Input, Restarting Program]");
            askIfOrder();
        }
    }

    public void askCustomerName() {
        System.out.print("Enter your name: ");
        this.customerName = userInput.nextLine();
    }

    public void createOrder(String customerName) {
        System.out.println("\n[Order for " + this.customerName + " coming right up!]\n");
        BurgerInfo customerOrder = new BurgerInfo(this.customerName);
        this.orderReceipt = customerOrder.askBurgerInfo();
    }

    public void printReceipt() {
        System.out.println(this.orderReceipt);
    }

}
