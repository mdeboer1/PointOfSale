/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This is the pure abstraction layer for the DIP and Strategy patterns.
 * @author mdeboer1
 * @version 1.00
 */
public interface DiscountStrategy {
    
    /**
     * This is the method that must be overridden in any implementing class
     * of this Discount Strategy.
     * @return 
     */
    public abstract double getDiscountAmount();
    
}
