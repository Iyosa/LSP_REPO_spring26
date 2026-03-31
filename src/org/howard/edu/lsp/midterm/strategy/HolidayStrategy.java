package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for holiday promotional pricing (15% discount).
 * 
 * @author Iyobosa Eguakun
 */
public class HolidayStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.85;
    }
}