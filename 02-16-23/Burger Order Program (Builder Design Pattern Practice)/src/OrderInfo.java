import java.util.Scanner;

public class OrderInfo implements OrderInfoMethods {

    Scanner userInput = new Scanner(System.in);
    char userChoice;
    String customerName;
    StringBuilder orderReceipt;
    int orderTotalCost;

    public void askIfOrder() {

        /* Asks the user if they want to order a burder */
        askIfOrderConfirm();
        /* If y, confirm order, create a burgerInfo object, & execute askInfo method */
        checkInput();
        /* Asks the user for their customer name */
        askCustomerName();
        /* Creates an order with the name of the user */
        createOrder(customerName);
        /* Prints the receipt */
        printReceipt();
        /* Asks for the user's confirmation for their order */
        askUserOrderConfirmation();
        /* Asks the user if they want to order another burger */
        askUserOrderAgain();

    }

    public void askIfOrderConfirm() {
        System.out.printf("\n%50s\n\n", "[Burger Order Program]");
        System.out.print("Do you want to order a burger? [y/n] : ");
        this.userChoice = this.userInput.next().charAt(0);
        this.userInput.nextLine(); // we put nextLine here to fix console text formatting
    }

    public void checkInput() {
        if (Character.toLowerCase(this.userChoice) == 'y') {
            /* Print confirmation message & ask for userName */
            System.out.println("\n[Confirmed!]\n");
        } else if (Character.toLowerCase(this.userChoice) == 'n') {
            /* Cancels order & terminates program */
            System.out.println("\n[Cancelled!]\n");
            System.exit(0);
        } else {
            /* If the userChoice in invalid */
            System.out.println("\n[Invalid Input, Restarting Program]");
            askIfOrder();
        }
    }

    public void askCustomerName() {
        System.out.print("Enter your name: ");
        this.customerName = this.userInput.nextLine();
    }

    public void createOrder(String customerName) {
        System.out.println("\n[Order for " + this.customerName + " coming right up!]");
        BurgerInfo customerOrder = new BurgerInfo(this.customerName);
        this.orderReceipt = customerOrder.askBurgerInfo();
        this.orderTotalCost = customerOrder.getTotalCost(); // get the total cost from BurgerInfo
    }

    public void printReceipt() {
        System.out.println(this.orderReceipt);
    }

    public void askUserOrderConfirmation() {
        System.out.print("Confirm Order? [y/n] : ");
        this.userChoice = this.userInput.next().charAt(0);
        if (Character.toLowerCase(this.userChoice) == 'y') {
            System.out.println("\n[Order Confirmed!]\n");
            askOrderPayment(); // ask for payment if order is confirmed
        } else if (Character.toLowerCase(this.userChoice) == 'n') {
            System.out.println("\n[Order Cancelled!]\n"); // print cancel message
        } else {
            System.out.println("\n[Invalid Input, Restarting Confirmation]\n");
            askUserOrderConfirmation(); // runs this method again
        }

    }

    public void askUserOrderAgain() {
        System.out.print("Do you want to order another burger? [y/n] : ");
        this.userChoice = this.userInput.next().charAt(0);
        if (Character.toLowerCase(this.userChoice) == 'y') {
            askIfOrder(); // runs the entire program again
        } else if (Character.toLowerCase(this.userChoice) == 'n') {
            System.out.println("\n[Understood, Enjoy Your Day!]\n");
            System.exit(0); // terminates the JVM, stops the program
        } else {
            System.out.println("\n[Invalid Input, Restarting Prompt]\n");
            askUserOrderAgain(); // executes this method again
        }
    }

    public void askOrderPayment() {
        System.out.println("[Please pay P" + this.orderTotalCost + " to complete your transaction]\n");
        System.out.print("Do you agree to pay P" + this.orderTotalCost + " [y/n] : ");
        this.userChoice = this.userInput.next().charAt(0);
        if (Character.toLowerCase(this.userChoice) == 'y') {
            System.out.println("\n[Transaction Successful]\n");
            System.out.println("[P" + this.orderTotalCost + " deducted from account]\n");
        } else if (Character.toLowerCase(this.userChoice) == 'n') {
            System.out.println("\n[Transaction Cancelled]\n");
        } else {
            System.out.println("\n[Invalid Input, Restarting Prompt]\n");
            askOrderPayment();
        }
    }

}
