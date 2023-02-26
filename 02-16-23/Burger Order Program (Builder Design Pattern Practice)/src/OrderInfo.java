import java.util.Scanner;

public class OrderInfo implements OrderInfoMethods {

    /* Scanner object to accept user input */
    Scanner userInput = new Scanner(System.in);
    /* Holds the choices of the user for each prompt */
    char userChoice;
    /* Contain's the customer's name */
    String customerName;
    /* Contains information about the order of the user */
    StringBuilder orderReceipt;
    /* Storing the total cost of the user's order */
    int orderTotalCost;
    /* For detecting and handling errors and misinputs */
    boolean errorExists;

    public void askIfOrder() {

        /* Asks the user if they want to order a burder */
        askIfOrderConfirm();
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
        /* Loops until the user either types in y or n */
        do {
            System.out.print("Do you want to order a burger? [y/n] : ");
            this.userChoice = this.userInput.next().charAt(0);
            this.userInput.nextLine(); // we put nextLine here to fix console text formatting
            checkInput();
        } while (errorExists);
    }

    public void checkInput() {
        /* If y, confirm order and make errorExist false */
        if (Character.toLowerCase(this.userChoice) == 'y') {
            /* Print confirmation message & ask for userName */
            System.out.println("\n[Confirmed! Proceeding with order process!]\n");
            this.errorExists = false;
        }
        /* If n, cancel and make errorExist false */
        else if (Character.toLowerCase(this.userChoice) == 'n') {
            /* Cancels order & terminates program */
            System.out.println("\n[Cancelled! Have a nice day!]\n");
            this.errorExists = false;
            System.exit(0);
        }
        /* If the user's input is not y or n, set errorExists to true */
        else {
            /* If the userChoice in invalid */
            System.out.println("\n[Invalid Input, Restarting Program]\n");
            this.errorExists = true;
        }
    }

    public void askCustomerName() {
        System.out.print("Enter your name: ");
        this.customerName = this.userInput.nextLine();
    }

    public void createOrder(String customerName) {
        System.out.println("\n[Order for " + this.customerName + " coming right up!]");
        /* Creates a BurgerInfo object */
        BurgerInfo customerOrder = new BurgerInfo(this.customerName);
        /* Info about order from BurgerInfo object referenced by orderReceipt */
        this.orderReceipt = customerOrder.askBurgerInfo();
        /* Gets total cost from our BurgerInfo object */
        this.orderTotalCost = customerOrder.getTotalCost();
    }

    public void printReceipt() {
        System.out.println(this.orderReceipt);
    }

    public void askUserOrderConfirmation() {
        /* Loops until the user either chooses y or n */
        do {
            System.out.print("Confirm Order? [y/n] : ");
            this.userChoice = this.userInput.next().charAt(0);
            if (Character.toLowerCase(this.userChoice) == 'y') {
                System.out.println("\n[Order Confirmed!]\n");
                askOrderPayment(); // ask for payment if order is confirmed
                this.errorExists = false;
            } else if (Character.toLowerCase(this.userChoice) == 'n') {
                System.out.println("\n[Order Cancelled!]\n"); // print cancel message
                this.errorExists = false;
            } else {
                System.out.println("\n[Invalid Input, Restarting Confirmation]\n");
                this.errorExists = true; // loops do while loop
            }
        } while (errorExists);

    }

    public void askUserOrderAgain() {
        /* Loops until the user either chooses y or n */
        do {
            System.out.print("Do you want to order another burger? [y/n] : ");
            this.userChoice = this.userInput.next().charAt(0);
            if (Character.toLowerCase(this.userChoice) == 'y') {
                this.errorExists = false;
                askIfOrder(); // runs the entire program again
            } else if (Character.toLowerCase(this.userChoice) == 'n') {
                System.out.println("\n[Understood, Enjoy Your Day!]\n");
                this.errorExists = false;
                System.exit(0); // terminates the JVM, stops the program
            } else {
                System.out.println("\n[Invalid Input, Restarting Prompt]\n");
                this.errorExists = true;
            }
        } while (errorExists);
    }

    public void askOrderPayment() {
        /* Loops until the user either chooses y or n */
        do {
            System.out.println("[Please pay P" + this.orderTotalCost + " to complete your transaction]\n");
            System.out.print("Do you agree to pay P" + this.orderTotalCost + " [y/n] : ");
            this.userChoice = this.userInput.next().charAt(0);
            if (Character.toLowerCase(this.userChoice) == 'y') {
                System.out.println("\n[Transaction Successful]\n");
                this.errorExists = false;
                System.out.println("[P" + this.orderTotalCost + " deducted from account]\n");
            } else if (Character.toLowerCase(this.userChoice) == 'n') {
                System.out.println("\n[Transaction Cancelled]\n");
                this.errorExists = false;
            } else {
                System.out.println("\n[Invalid Input, Restarting Prompt]\n");
                this.errorExists = true;
            }
        } while (errorExists);
    }

}
