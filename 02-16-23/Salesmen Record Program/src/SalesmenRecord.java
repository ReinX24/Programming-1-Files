import java.math.BigDecimal;
import java.util.Scanner;

public class SalesmenRecord {

    /* Contains the name of the salesMen */
    private String salesmenName;
    /* Contains salesMen Code */
    private int salesmenCode;
    /* Array that contains all the possible choices for salesmenCode */
    private int[] salesmenCodeChoices = { 1, 2, 3, 4 };
    /* Checks if the entered code by the user is valid */
    private boolean validCode = false;
    /*
     * BigInteger array that contains weekly records of sales, we are going to use
     * the BigInteger class since the numbers that the user may input may exceed the
     * capabilities of int
     */
    private BigDecimal[] monthlySales = new BigDecimal[4];
    /* BigInteger variable that contains the sum of all monthlySales */
    private BigDecimal sumOfMonthlySales = BigDecimal.valueOf(0);
    /* Basic Pay */
    private BigDecimal basicPay = BigDecimal.valueOf(0);
    /* Work Tax deduction */
    private BigDecimal workTax = BigDecimal.valueOf(0);
    /* PAG-IBIG deduction */
    private BigDecimal pagIbig = BigDecimal.valueOf(0);
    /* SSS deduction */
    private BigDecimal socialSecuritySystem = BigDecimal.valueOf(0);
    /* Calculated commission */
    private BigDecimal salesmenCommission = BigDecimal.valueOf(0);
    /* Net Pay */
    private BigDecimal netPay = BigDecimal.valueOf(0);
    /* Scanner to accept user input */
    Scanner userInput;

    public void askInfo() {
        /* Finish creating Scanner object */
        userInput = new Scanner(System.in);
        /* Show program title & ask for name */
        System.out.println("[Salesmen Record Program]");
        System.out.print("Enter Name: ");
        salesmenName = userInput.nextLine();
        /* Ask for salesmen code */
        System.out.print("Enter Code (1, 2, 3, 4): ");
        salesmenCode = userInput.nextInt();
        /* Check if the entered salesmenCode is part of the choices */
        for (int i = 0; i < salesmenCodeChoices.length; i++) {
            if (salesmenCode == salesmenCodeChoices[i]) {
                validCode = true;
            }
        }
        if (validCode) {
            System.out.println("[Salesmen Code Valid]");
        } else {
            System.out.println("[Salesmen Code NOT Recognized, Terminating Program]");
            userInput.close(); // closes our Scanner object
            System.exit(0); // terminates program
        }
        /* Ask for monthly sales (per week) */
        for (int i = 0; i < monthlySales.length; i++) {
            System.out.print("Week " + (i + 1) + " Sales : ");
            monthlySales[i] = userInput.nextBigDecimal();
        }
        /* Add all of the monthlySales earnings */
        for (int i = 0; i < monthlySales.length; i++) {
            sumOfMonthlySales = sumOfMonthlySales.add(monthlySales[i]);
        }
        /* Calculate for Basic Pay */
        /*
         * We are going to base the basic pay calculation on the entered salesmen code
         */
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
        /* Calculating for Commissions */
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
        /* Calculating for workTax */
        switch (salesmenCode) {
            case 1:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.10))).multiply(BigDecimal.valueOf(0.12));
                break;
            case 2:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.15))).multiply(BigDecimal.valueOf(0.12));
                break;
            case 3:
                workTax = basicPay.add(salesmenCommission.multiply(BigDecimal.valueOf(0.10))).multiply(BigDecimal.valueOf(0.12));
                break;
            case 4:
                workTax = salesmenCommission.multiply(BigDecimal.valueOf(0.12));
                break;
        }
        /* Calculating for PAG-IBIG deduction */
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
        /* Calculating for SSS deduction */
        switch (salesmenCode) {
            case 1:
                socialSecuritySystem = BigDecimal.valueOf(150).add(salesmenCommission.multiply(BigDecimal.valueOf(0.0275)));
                break;
            case 2:
                socialSecuritySystem = BigDecimal.valueOf(100).add(salesmenCommission.multiply(BigDecimal.valueOf(0.025)));
                break;
            case 3:
                socialSecuritySystem = BigDecimal.valueOf(94).add(salesmenCommission.multiply(BigDecimal.valueOf(0.015)));
                break;
            case 4:
                socialSecuritySystem = salesmenCommission.add(basicPay).multiply(BigDecimal.valueOf(0.015));
                break;
        }
        /* Calculating for Net Pay */
        netPay = netPay.add(basicPay.add(salesmenCommission).subtract(workTax.add(pagIbig.add(socialSecuritySystem))));
        /* Show employee information */
        System.out.println("Name: " + salesmenName);
        System.out.println("Code: " + salesmenCode);
        System.out.println("Total Sale: " + sumOfMonthlySales);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("Work Tax: " + workTax);
        System.out.println("PAG-IBIG: " + pagIbig);
        System.out.println("SSS: " + socialSecuritySystem);
        System.out.println("Commission: " + salesmenCommission);
        System.out.println("Net Pay: " + netPay);
    }

}
