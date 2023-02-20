import java.util.Scanner;

public class OrderInfo implements OrderInfoMethods{

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
        /* Closes userInput Scanner object */
        userInput.close();

    }

    public void askConfirm() {
        System.out.printf("%50s", "[Burger Order Program]\n");
        System.out.print("Do you want to order a burger? [y/n] : ");
        userChoice = userInput.next().charAt(0);
    }

    public void checkInput() {
        if (Character.toLowerCase(userChoice) == 'y') {
            /* Print confirmation message & ask for userName */
            System.out.println("[Confirmed!]");
        } else if (Character.toLowerCase(userChoice) == 'n') {
            /* Cancels order & terminates program */
            System.out.println("[Cancelled!]");
            userInput.close();
            return;
        } else {
            /* If the userChoice in invalid */
            System.out.println("[Invalid Input, Restarting Program]");
        }
    }

    public void askCustomerName() {
        System.out.print("Enter your name: ");
        customerName = userInput.nextLine();
    }

    public void createOrder(String customerName) {
        System.out.println("[Order for " + customerName + " coming right up!]");
        BurgerInfo customerOrder = new BurgerInfo(customerName);
        this.orderReceipt = customerOrder.askBurgerInfo();
    }

    public void printReceipt() {
        System.out.println(this.orderReceipt);
    }

}
