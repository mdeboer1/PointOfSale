/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author mdeboer1
 * This is the manager class for this project.  It delegates to all the other
 * class.  It receives information from the startup class, then sends and receives
 * information from the other classes as needed.
 */
public class POSRegister {
    private Receipt receipt;
    private FakeDataBase database;
    private LineItem lineItem;
    private Product product;
    private Customer customer;
    
    public POSRegister(){
        this.receipt = new Receipt();
    }
    
    public void setFirstLineItem(int quantity, String productID, String customerNumber){
        if (quantity < 1 || productID == null || productID.equals(" ") || customerNumber == null 
                || customerNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: Quantity must be a least one and productID and custemer"
                            + "number must be Strings");
        }
        //Create new FakeDataBase object to reference productID and customerNumber
        this.database = new FakeDataBase();
        customer = database.getCustomerInformation(customerNumber);
        product = database.getProductDescription(productID);
        //Create new LineItem object to hold line item information
        lineItem = new LineItem(product, quantity);
        receipt.setFirstLineItem(lineItem, customer);
    }
    
    public void setNextLineItem(int quantity, String productID, String customerNumber){
        if (quantity < 1 || productID == null || productID.equals(" ") || customerNumber == null 
                || customerNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: Quantity must be a least one and productID and custemer"
                            + "number must be Strings");
        }
        product = database.getProductDescription(productID);
        lineItem = new LineItem(product, quantity);
        receipt.setNewLineItem(lineItem);
    }

    public int getReceiptNumber() {
        return receipt.getReceiptNumber();
    }
    
    public String getReceipt(){
        return receipt.getReceipt();
    }
}    
