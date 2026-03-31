package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for customer price calculation.
 * 
 * @author Iyobosa Eguakun
 */
public interface PricingStrategy {
    /**
     * Calculates the price for a customer type.
     * 
     * @param price the base price
     * @return the final calculated price
     */
    double calculate(double price);
}