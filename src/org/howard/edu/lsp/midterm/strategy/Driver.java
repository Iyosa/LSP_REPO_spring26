package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to demonstrate the Strategy Pattern.
 * 
 * @author Iyobosa Eguakun
 */
public class Driver {
    /**
     * Main method to execute the strategy tests.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double basePrice = 100.0;

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(basePrice));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(basePrice));
    }
}