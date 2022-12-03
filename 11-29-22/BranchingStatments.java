class BranchingStatements {

    public static void main(String[] args) {

        // We will not demonstrate the different branching statements

        // These are: If, If else, If - else if - nested if, and Switch

        // First, we will create a varaible for our demonstration

        int numOne = 5;

        // If syntax
        if (numOne > 3) {
            // this checks if the numOne is greater than 3, if it is greater than 3 the code
            // block below will run
            System.out.println("Number is greater than 3");

        }

        // If else syntax
        if (numOne > 6) {
            // checks if numOne is greater than 6, numOne is not greater than 6, will not
            // run code below
            System.out.println("Number is greater than 6");

        }

        else {
            // if the if statement above returns false, it will run this instead
            System.out.println("Number is NOT greater than 6");

        }

        // If - else if - nested if syntax
        if (numOne > 6) {
            // returns false
            System.out.println("Number is greater than 6");

        }

        else if (numOne > 10) {
            // returns false
            System.out.println("Number is greater than 10");

        }

        else if (numOne < 7) {
            // numOne is less than 7, so the code below will run
            System.out.println("Number is less than 7");

        }

        else {
            // will only run if all of the statements above return false
            System.out.println("Did not satisfy any condition");

        }

        // Switch case syntax
        switch (numOne) { // we put the varable that we want our cases to check inside

            case 1: // numOne is not one so this will not run
                System.out.println("Number is 1");
                break;

            case 3: // numOne is also not 3
                System.out.println("Number is 3");
                break;

            case 5: // numOne is 5, the code below will run
                System.out.println("Number is 5");
                break;

            default:
                System.out.println("Number did not satisfy any of the conditions");

        }

    }

}