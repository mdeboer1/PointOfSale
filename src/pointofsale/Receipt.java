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
public class Receipt {
    //Static variable to count number of objects created, to be used for receiptNumber property
    public static int receiptNumberIncrementer = 1;
    private final int receiptNumber;
    private LineItem [] lineItems = new LineItem[1];
    
    public Receipt(){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }
    
    public void setFirstLineItem(LineItem lineItem){
        lineItems[0] = lineItem;
    }
    public void setNewLineItem(LineItem lineItem){
        LineItem [] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = lineItem;
        lineItems = tempArray;
    }
    
    public String getReceipt(){
        String temp = "";
        for (int i = 0; i <= lineItems.length - 1; i++){
             temp = lineItems[i].getCustomerNumber() + " " +
                    lineItems[i].getQuantity() + " " + lineItems[i].getProductNumber() +
                    " " + lineItems[i].getProductDescription() + " " + lineItems[i].getPrice() + 
                    " " + lineItems[i].getDiscountAmount();
        }
        return temp;
    }
}
