package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for member customers with 10% discount.
 * 
 * @author Iyobosa Eguakun
 */
public class MemberStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}