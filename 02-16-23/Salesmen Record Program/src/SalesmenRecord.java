import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesmenRecord implements SalesmenMethods {

    /* Contains the name of the salesMen */
    private String salesmenName;
    /* Contains salesMen Code */
    private int salesmenCode;
    /* Array that contains all the possible choices for salesmenCode */
    private int[] salesmenCodeChoices = { 1, 2, 3, 4 };
    /* Checks if the entered code by the user is valid */
    private boolean validCode;
    /*
     * BigInteger array that contains weekly records of sales, we are going to use
     * the BigInteger class since the numbers that the user may input may exceed the
     * capabilities of int
     */
    private BigDecimal[] monthlySales = new BigDecimal[4];
    /* BigInteger variable that contains the sum of all monthlySales */
    private BigDecimal sumOfMonthlySales;
    /* Basic Pay */
    private BigDecimal basicPay;
    /* Work Tax deduction */
    private BigDecimal workTax;
    /* PAG-IBIG deduction */
    private BigDecimal pagIbig;
    /* SSS deduction */
    private BigDecimal socialSecuritySystem;
    /* Calculated commission */
    private BigDecimal salesmenCommission;
    /* Net Pay */
    private BigDecimal netPay;
    /* Scanner to accept user input */
    Scanner userInput;

    public void askInfo() {
        /* Finish creating Scanner object */
        userInput = new Scanner(System.in);
        /* Show program title */
        System.out.printf("\n%50s\n", "[Salesmen Record Program]");
        /* Ask for user name */
        askName();
        /* Ask for salesmen code */
        askCode();
        /* Check if the entered salesmenCode is part of the choices */
        checkCodeValid();
        /* Ask for monthly sales (per week) */
        askWeeklySales();
        /* Add all of the monthlySales earnings */
        addWeeklySales();
        /* Calculate for Basic Pay */
        /*
         * We are going to base the basic pay calculation on the entered salesmen code
         */
        addBasicPay();
        /* Calculating for Commissions */
        calculateCommissions();
        /* Calculating for workTax */
        calculateWorkTax();
        /* Calculating for PAG-IBIG deduction */
        calculatePagIbig();
        /* Calculating for SSS deduction */
        calculateSSS();
        /* Calculating for Net Pay */
        calculateNetPay();
        /* Show employee information */
        printSalesmenInfo();
        /*
         * Asks the user if they want to input another set of information or restart the
         * program
         */
        askRestartProgram();
        /* Closing our Scanner object */
        userInput.close();
    }

    public void askName() {
        System.out.print("\n\tEnter Name: ");
        salesmenName = userInput.nextLine();
    }

    public void askCode() {
        try {
            salesmenCode = 0;
            System.out.print("\n\tEnter Code [1, 2, 3, 4]: ");
            salesmenCode = userInput.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("\n[Invalid Input, Restarting Program]");
            askInfo(); // executes askInfo again
        }
    }

    public void checkCodeValid() {
        validCode = false;
        for (int i = 0; i < salesmenCodeChoices.length; i++) {
            if (salesmenCodeChoices[i] == salesmenCode) {
                validCode = true;
            }
        }
        if (validCode) {
            System.out.printf("\n%s\n", "[Code Validated]");
        } else {
            System.out.printf("\n%s\n", "[Code Invalid, Restarting Program]");
            askInfo();
        }
    }

    public void askWeeklySales() {
        try {
            for (int i = 0; i < monthlySales.length; i++) {
                monthlySales[i] = BigDecimal.valueOf(0);
                System.out.print("\n\tWeek " + (i + 1) + " Sales : ");
                monthlySales[i] = userInput.nextBigDecimal();
            }
        } catch (InputMismatchException ex) {
            System.out.println("\n[Invalid Input, Restarting Program]");
            askInfo();
        }

    }

    public void addWeeklySales() {
        sumOfMonthlySales = BigDecimal.valueOf(0);
        for (int i = 0; i < monthlySales.length; i++) {
            sumOfMonthlySales = sumOfMonthlySales.add(monthlySales[i]);
        }
    }

    public void addBasicPay() {
        basicPay = BigDecimal.valueOf(0);
        switch (salesmenCode) {
            case 1:
                basicPay = BigDecimal.valueOf(20000);
                break;
            case 2:
                basicPay = BigDecimal.valueOf(25000);
                break;
            case 3:
                basicPay = BigDecimal.valueOf(18000);
                break;
            case 4:
                basicPay = BigDecimal.valueOf(15000);
                break;
        }
    }

    public void calculateCommissions() {
        salesmenCommission = BigDecimal.valueOf(0);
        switch (salesmenCode) {
            case 1:
                salesmenCommission = sumOfMonthlySales.subtract(BigDecimal.valueOf(250000))
                        .multiply(BigDecimal.valueOf(0.20));
                break;
            case 2:
                salesmenCommission = sumOfMonthlySales.subtract(BigDecimal.valueOf(300000))
                        .multiply(BigDecimal.valueOf(0.20));
                break;
            case 3:
                salesmenCommission = sumOfMonthlySales.subtract(BigDecimal.valueOf(150000))
                        .multiply(BigDecimal.valueOf(0.25));
                break;
            case 4:
                salesmenCommission = sumOfMonthlySales.subtract(BigDecimal.valueOf(200000))
                        .multiply(BigDecimal.valueOf(0.25));
                break;
        }
    }

    public void calculateWorkTax() {
        workTax = BigDecimal.valueOf(0);
        switch (salesmenCode) {
            case 1:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.10)))
                        .multiply(BigDecimal.valueOf(0.12));
                break;
            case 2:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.15)))
                        .multiply(BigDecimal.valueOf(0.12));
                break;
            case 3:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.10)))
                        .multiply(BigDecimal.valueOf(0.12));
                break;
            case 4:
                workTax = salesmenCommission.multiply(BigDecimal.valueOf(0.12));
                break;
        }
    }

    public void calculatePagIbig() {
        pagIbig = BigDecimal.valueOf(0);
        switch (salesmenCode) {
            case 1:
                pagIbig = pagIbig.add(basicPay.multiply(BigDecimal.valueOf(0.03)));
                break;
            case 2:
                pagIbig = pagIbig.add(basicPay.multiply(BigDecimal.valueOf(0.0275)));
                break;
            case 3:
                pagIbig = pagIbig.add(basicPay.multiply(BigDecimal.valueOf(0.0175)));
                break;
            case 4:
                pagIbig = pagIbig.add(basicPay.multiply(BigDecimal.valueOf(0.015)));
                break;
        }
    }

    public void calculateSSS() {
        socialSecuritySystem = BigDecimal.valueOf(0);
        switch (salesmenCode) {
            case 1:
                socialSecuritySystem = BigDecimal.valueOf(150)
                        .add(salesmenCommission.multiply(BigDecimal.valueOf(0.0275)));
                break;
            case 2:
                socialSecuritySystem = BigDecimal.valueOf(100)
                        .add(salesmenCommission.multiply(BigDecimal.valueOf(0.025)));
                break;
            case 3:
                socialSecuritySystem = BigDecimal.valueOf(94)
                        .add(salesmenCommission.multiply(BigDecimal.valueOf(0.015)));
                break;
            case 4:
                socialSecuritySystem = salesmenCommission.add(basicPay).multiply(BigDecimal.valueOf(0.015));
                break;
        }
    }

    public void calculateNetPay() {
        netPay = BigDecimal.valueOf(0);
        netPay = netPay.add(basicPay.add(salesmenCommission).subtract(workTax.add(pagIbig.add(socialSecuritySystem))));
    }

    public void printSalesmenInfo() {
        System.out.printf("\n%47s\n", "[Salesmen Information]");
        System.out.printf("\n\t\t[%s\t:\t%14s]\n", "Salesmen Name", salesmenName);
        System.out.printf("\n\t\t[%s\t:\t%14s]\n", "Salesmen Code", salesmenCode);
        System.out.printf("\n\t\t[%s\t:\t%14s]\n", "Total Sale", sumOfMonthlySales);
        System.out.printf("\n\t\t[%s\t:\t%14s]\n", "Basic Pay", basicPay);
        System.out.printf("\n\t\t[%s\t:\t%14.2f]\n", "Work Tax", workTax);
        System.out.printf("\n\t\t[%s\t:\t%14.2f]\n", "PAG-IBIG", pagIbig);
        System.out.printf("\n\t\t[%s\t:\t%14.2f]\n", "SSS Fund", socialSecuritySystem);
        System.out.printf("\n\t\t[%s\t:\t%14.2f]\n", "Commission", salesmenCommission);
        System.out.printf("\n\t\t[%s\t:\t%14.2f]\n\n", "Total Net Pay", netPay);
    }

    public void askRestartProgram() {
        char userChoice = ' ';
        System.out.print("Do you want to input another data set? [y/n]: ");
        userChoice = userInput.next().charAt(0);
        if (Character.toLowerCase(userChoice) == 'y') {
            System.out.println("\n[Restarting Program]");
            askInfo();
        } else if (Character.toLowerCase(userChoice) == 'n') {
            System.out.println("\n[Terminated Program]");
            userInput.close();
        } else {
            System.out.println("\n[Invalid Choice, Restarting Program]");
            askInfo();
        }

    }

}
