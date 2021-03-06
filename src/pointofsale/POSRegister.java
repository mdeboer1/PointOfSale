/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This is the manager class for this project.  It delegates to all the other
 * class.  It receives information from the startup class, then sends and receives
 * information from the other classes as needed.
 * @author mdeboer1
 * @version 1.00
 */
public class POSRegister {
    private final Receipt receipt;
    
    /**
     * Constructor for POSRegister class, creates a Receipt object.
     * @param quantity - Contains quantity received from Startup class, passes it to
     * Receipt constructor.
     * @param productID - Contains product ID received from Startup class, passes it to
     * Receipt constructor.
     * @param customerNumber - Contains customerNumber received from Startup class, passes it to
     * Receipt constructor. 
     * @param receiptStrategy - ReceiptStrategy object
     * @param database - A database object
     */
    public POSRegister(int quantity, String productID, String customerNumber,
            ReceiptStrategy receiptStrategy, DatabaseStrategy database){ 
        if (quantity < 1 ){
            throw new IllegalArgumentException(
                    GlobalConstants.QUANTITY_WARNING_MESSAGE);
        }
        else if (customerNumber == null || customerNumber.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.CUSTOMER_NUMBER_WARNING_MESSAGE);
        }
        else if (productID == null || productID.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        else if (receiptStrategy == null){
            throw new IllegalArgumentException(
                    GlobalConstants.RECEIPT_OBJECT_WARNING_MESSAGE);
        }
        this.receipt = new Receipt(quantity, productID, customerNumber, receiptStrategy, database); 
    }
    
    /**
     * This method allows a new line item to be created in Receipt class
     * @param quantity - Contains quantity received from Startup class, passes it to
     * Receipt constructor.
     * @param productID - Contains product ID received from Startup class, passes it to
     * Receipt constructor.
     */
    public final void addNewLineItem(int quantity, String productID){
        if (quantity < 1 || productID == null || productID.equals(" ")){
            throw new IllegalArgumentException(
                    "error: Quantity must be a least one and productID must be a String");
        }
        receipt.addNewLineItem(quantity, productID);
    }
    
    /**
     * Returns the receipt number from receipt
     * @return 
     */
    public final int getReceiptNumber() {
        return receipt.getReceiptNumber();
    }
    
    /**
     * This methods calls the receipt to generate the console printed receipt.
     */
    public final void generateConsoleReceipt(){
//        receipt.getConsoleReceipt();
        receipt.outputReceiptStrategy();
    }
}    
