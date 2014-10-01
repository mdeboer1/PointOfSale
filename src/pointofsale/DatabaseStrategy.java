/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pointofsale;

/**
 * This is the abstract layer for the Database in this point of sale program.
 * It is intended to be implemented by concrete databases.
 * @author mdeboer1
 */
public interface DatabaseStrategy {
    
    public abstract Product getProductInformation(String productNumber);
    public abstract Customer getCustomerInformation(String customerNumber);
}
