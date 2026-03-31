package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers with 20% discount.
 * 
 * @author Iyobosa Eguakun
 */
public class VIPStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.80;
    }
}