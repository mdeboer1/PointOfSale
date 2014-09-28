/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author mdeboer1
 * This is the pure abstraction layer for the DIP and Strategy patterns.
 */
public interface DiscountStrategy {
    
    public abstract double getDiscountAmount();
    
}
