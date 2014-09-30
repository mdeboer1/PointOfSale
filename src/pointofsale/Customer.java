/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class creates a simple customer example existing of only a customerNumber
 * property and an array to store receiptHistory. 
 * @author mdeboer1
 * @version 1.00
 */
public class Customer {
    private String customerNumber;
    private int[] receiptHistory = new int[1];
    
    public Customer(String customerNumber){
        setCustomerNumber(customerNumber);
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    private void setCustomerNumber(String customerNumber) {
        if (customerNumber == null || customerNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: custemer number must be a valid String");
        }
        this.customerNumber = customerNumber;
    }
    /**
     * This method allows the Customer class to store all the receipt numbers
     * for that particular Customer instance
     * @param receiptNumber - Used to append the receiptNumber to receiptHistory
     * array
     */
    public final void addReceiptToHistory(int receiptNumber){
        if (receiptNumber <= 0){
            throw new IllegalArgumentException(
                "error: receiptNumber must be greater than zero");
        }
        int [] tempArray = new int[receiptHistory.length + 1];
        System.arraycopy(receiptHistory, 0, tempArray, 0, receiptHistory.length);
        tempArray[receiptHistory.length] = receiptNumber;
        receiptHistory = tempArray;
    }
    
}
