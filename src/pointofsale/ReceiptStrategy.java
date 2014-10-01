/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * Not a used interface as of this version
 * @author mdeboer1
 * @version 1.00
 */
public interface ReceiptStrategy {
    
    public abstract void generateReceipt(Customer customer, LineItem [] lineItems, 
            int receiptNumber);
    
}
