package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for regular customers with no discount.
 * 
 * @author Iyobosa Eguakun
 */
public class RegularStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price;
    }
}