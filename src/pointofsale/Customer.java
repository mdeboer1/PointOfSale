/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author mdeboer1
 */
public class Customer {
    private String customerNumber;
    
    public Customer(String customerNumber){
        setCustomerNumber(customerNumber);
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    private void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
