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
    
    public POSRegister(int quantity, String productID, String customerNumber){ //take custNum as argument, send to Receipt constructor
        if (quantity < 1 || productID == null || productID.equals(" ") || customerNumber == null 
                || customerNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: Quantity must be a least one and productID and custemer"
                            + "number must be Strings");
        }
        this.receipt = new Receipt(quantity, productID, customerNumber); 
    }
    
    public void addNewLineItem(int quantity, String productID){
        if (quantity < 1 || productID == null || productID.equals(" ")){
            throw new IllegalArgumentException(
                    "error: Quantity must be a least one and productID must be a String");
        }
        receipt.addNewLineItem(quantity, productID);
    }

    public int getReceiptNumber() {
        return receipt.getReceiptNumber();
    }
    
    public void generateConsoleReceipt(){
        receipt.getConsoleReceipt();
    }
}    
