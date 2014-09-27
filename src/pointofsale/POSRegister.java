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
public class POSRegister {
    private Receipt receipt;
    private FakeDataBase database;
    private LineItem lineItem;
    private Product product;
    private Customer customer;
    
    public POSRegister(){
        //Create new Receipt object
        this.receipt = new Receipt();
//        //Create new FakeDataBase object to reference productID and customerNumber
//        this.database = new FakeDataBase();
//        customer = database.getCustomerInformation(customerNumber);
//        product = database.getProductDescription(productID);
//        //Create new LineItem object to hold line item information
//        lineItem = new LineItem(product, quantity, customer, receipt);
    }
    
    public void setNewLineItem(int quantity, String productID, String customerNumber){
        //Create new FakeDataBase object to reference productID and customerNumber
        this.database = new FakeDataBase();
        customer = database.getCustomerInformation(customerNumber);
        product = database.getProductDescription(productID);
        //Create new LineItem object to hold line item information
        lineItem = new LineItem(product, quantity, customer, receipt);
    }

    public int getReceiptNumber() {
        return receipt.getReceiptNumber();
    }
    
    public String getReceipt(){
        return receipt.getReceipt();
    }
}    
