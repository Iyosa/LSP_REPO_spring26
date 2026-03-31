package org.howard.edu.lsp.midterm.strategy;

/**
 * This new implemantaation is closed for modification but open for extension
 * through new classes
 * * @author Iyobosa Eguakun
 */
public class PriceCalculator {
    // CHANGE: Replaced hardcoded logic with a strategy interface
    // This splits up the discount rules
    private PricingStrategy strategy;

    /**
     * Sets the pricing strategy/discount to be used
     * * @param strategy The specific discount strategy to apply
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price
     * CHANGE: Removed all if statements
     * * @param price The base price of the item
     * 
     * @return The price after the strategy-specific discount is applied
     */
    public double calculatePrice(double price) {
        // Validates a strategy is selected before calculation
        if (strategy == null) {
            throw new IllegalStateException("Pricing strategy must be set before calculation.");
        }

        // The context now simply delegates the work to the strategy
        return strategy.calculate(price);
    }
}