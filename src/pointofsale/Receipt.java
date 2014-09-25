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
    private String productNumber;
    private String productDescription;
    private int quantity;
    private double price;
    private String customerNumber;
   
    public Receipt(){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }
    
    public void setLineItem(int quantity, Product product, Customer customer){
        this.productNumber = product.getProductCode();
        this.productDescription = product.getProductDescription();
        this.quantity = quantity;
        this.price = product.getPrice();
        this.customerNumber = customer.getCustomerNumber();
    }
    
    public String getReceipt(){
        String receipt = " ";
        
        return receipt;
    }
}
