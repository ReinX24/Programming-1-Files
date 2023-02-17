public interface SalesmenMethods {

    /*
     * This interface contains all the methods that we will implement in
     * SalesmenProgram. This will serve as documentation for the different methods
     * and their functions in the program.
     */

    /* Method that asks for the name of the user */
    void askName();

    /* Asks Salesmen code */
    void askCode();

    /* Check if Salemen code is among the choices */
    void checkCodeValid();

    /* Add sales of each week in a month(4 weeks) */
    void askWeeklySales();

    /* Add all the sales of each week */
    void addWeeklySales();

    /* Set basicPay in respect to Salesmen code */
    void addBasicPay();

    /* Calculate the Salesmen's commission */
    void calculateCommissions();

    /* Calculate workTax */
    void calculateWorkTax();

    /* Calculate PAG-IBIG deductions */
    void calculatePagIbig();

    /* Calculate SSS deductions */
    void calculateSSS();

    /* Calculate netPay */
    void calculateNetPay();

    /*
     * Prints Total Sale, Basic Pay, Work Tax, PAG-IBIG, SSS, Commission, & Net Pay
     */
    void printSalesmenInfo();

}
