/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This is the interface that is used as the pure abstraction layer in the this
 * package for DIP compliant strategy of interchangeable receipt types.
 * @author mdeboer1
 * @version 1.00
 */
public interface ReceiptStrategy {
    
    public abstract void generateReceipt(Customer customer, LineItem [] lineItems, 
            int receiptNumber);
    
}
