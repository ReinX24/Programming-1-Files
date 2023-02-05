import java.util.Scanner;

/*
 * AUTHOR: Rein Aldwin E. Solis
 * UNIVERSITY: Universidad De Dagupan
 * DATE: 02/05/23
 */

/* Create a class named NewMe */
public class NewMe {

    /* Inside the class, create the main method */
    public static void main(String[] args) {

        /*
         * Solution for a Programming Activity from a friend in University of Pangasinan
         * (UPANG).
         */

        /* Calling the nameProducts() method */
        nameProducts();

    }

    /* Inside the class, create another method to name products */
    public static void nameProducts() {
        /* Inside the method */
        System.out.println("\n[Products Method]\n"); // title when the method is executed
        /* Create an array that contains the ff: */
        /*
         * 1) 3 in 1 Soap for only 300 pesos
         * 2) Kojic Soap for only 250 pesos
         * 3) Rejuvinate kit for only 1250 pesos
         */

        String[] productArr = { "1) 3 in 1 Soap for only 300 pesos", "2) Kojic Soap for only 250 pesos",
                "3) Rejuvinate kit for only 1250 pesos" };

        /* Display the array that you created using a loop */
        for (int i = 0; i < productArr.length; i++) {
            System.out.println(productArr[i]);
        }
        /* Create a Scanner variable */
        Scanner scanOne = new Scanner(System.in);
        /* Display "Which product do you want?" and add input */
        System.out.print("\nWhich product do you want?[ 1 | 2 | 3 ]: ");
        int userChoice = scanOne.nextInt();
        /* Display "How many items do you want?" and add input */
        System.out.print("How many items do you want?(Enter a number): ");
        int userChoiceAmount = scanOne.nextInt();
        /* Calculate the price and number of items. */
        float totalBill = 0.0f; // where we will store our total price
        switch (userChoice) {
            case 1:
                totalBill = userChoiceAmount * 300;
                break;

            case 2:
                totalBill = userChoiceAmount * 250;
                break;

            case 3:
                totalBill = userChoiceAmount * 1250;
                break;

            // if the item is not within the choices
            default:
                System.out.println("[Invalid item!]");
                scanOne.close(); // closing Scanner object before termination
                return; // terminates the program
        }
        /*
         * Display "This is your total bill <amount>". (e.g. This is your total bill
         * 69.0)
         */
        System.out.println("\nThis is your total bill: " + totalBill);
        /* Calling the customerDetails method */
        customerDetails();

        /*
         * The reason why we call the customerDetails method first before closing our
         * Scanner object (scanOne) is because if we close scanOne then call
         * nameProducts() method, it causes an exception. To fix this, we instead call
         * the nameProducts() method first before closing scanOne.
         */

        /* Closing our Scanner object */
        scanOne.close();
    }

    /* Inside the class, create another method to name customerDetails */
    public static void customerDetails() {
        /* Inside the method */
        System.out.println("\n[Customer Details Method]\n");
        /*
         * Creating another Scanner object since we cannot use the one within the
         * nameProducts() method
         */
        Scanner scanTwo = new Scanner(System.in);
        /* Display "What's your Name?" and add input. */
        System.out.print("What's your Name?: ");
        String customerName = scanTwo.nextLine();
        /* Display "What's your Gender[M/F]?" and add input. */
        System.out.print("What's your Gender[M/F]?: ");
        String customerGender = scanTwo.nextLine();
        /* Display "What's your Location?" and add input. */
        System.out.print("What's your Location?: ");
        String customerLocation = scanTwo.nextLine();
        /* Display "What's your Age" and add input. */
        System.out.print("What's your age?[Enter a number]: ");
        int customerAge = scanTwo.nextInt();
        /* Display "My name is <name>" */
        System.out.println("\nMy name is " + customerName);
        /* Display "My gender is <gender>" */
        System.out.println("My gender is " + customerGender);
        /* Display "My location is <location>" */
        System.out.println("My location is " + customerLocation);
        /* Display "My age is <age>" */
        System.out.println("My age is " + customerAge);
        /* Closing our Scanner object */
        scanTwo.close();
    }

    /* Call all the methods */

}
