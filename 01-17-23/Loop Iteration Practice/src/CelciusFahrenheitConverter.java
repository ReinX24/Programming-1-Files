public class CelciusFahrenheitConverter {

    public static void main(String[] args) {

        /*
         * Create a program that will print a table containing Fahrenheit temperatures
         * and their corresponding Celcius conversion temperatures. Start at 0 F, add 20
         * for each iteration until it reaches 300.
         * 
         */

        // Fahrenheit to Celcius Table
        float tempFahrenheit = 0.0f; // for fahrenheit temperatures
        float tempCelcius = 0.0f; // for celcius temperatures
        float ADD_NUMBER_TEMP = 20; // variable to be added for each fahrenheit temp
        float TEMP_MAX = 300; // maximum temperature for conversion

        System.out.println("\n[Fahrenheit to Celcius Table]");
        System.out.printf("%-10s | %-10s\n", "Fahrenheit", "Celcius");
        while (tempFahrenheit <= TEMP_MAX) { // loops until tempFahrenheit is less than or equal to TEMP_MAX (300)
            tempCelcius = 5.0f / 9.0f * (tempFahrenheit - 32); // formula for converting fahrenheit to celcius
            System.out.printf("%-10.0f : %-10.0f\n", tempFahrenheit, tempCelcius); // printing both temperatures
            tempFahrenheit += ADD_NUMBER_TEMP; // add 20 to tempFahrenheit
        }

        // Celcius to Fahrenheit Table
        tempFahrenheit = 0.0f; // resets value
        tempCelcius = 0.0f;

        System.out.println("\n[Celcius to Fahrenheit Table]");
        System.out.printf("%-10s | %-10s\n", "Celcius", "Fahrenheit");
        while (tempCelcius <= TEMP_MAX) {
            tempFahrenheit = 9.0f / 5.0f * tempCelcius + 32; // formula for converting celcius to fahrenheit
            System.out.printf("%-10.0f : %-10.0f\n", tempCelcius, tempFahrenheit); // printing both temperatures
            tempCelcius += ADD_NUMBER_TEMP;
        }

    }

}
