/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;

/**
 *This class creates the receipt.  It uses a custom constructor to create the
 receipt number and adds one to receiptNumberIncrementer (which actually just
 counts the number of objects created) that is used for incrementing the receipt
 number by one.  Line items are added in either the setFirstLineItem or addNewLineItem
 because different things occur if it is the first line item or not.  getConsoleReceipt
 method creates the formatting for the receipt as it is shown in the console
 output
 * @author mdeboer1
 * @version 1.00
 
 */
public class Receipt {
    //Static variable to count number of objects created, to be used for receiptNumber property
    public static int receiptNumberIncrementer = 1;
    private final int receiptNumber;
    private LineItem [] lineItems = new LineItem[1];
    private DatabaseStrategy database;
    private LineItem lineItem;
    private Customer customer;
    private ReceiptStrategy receiptStrategy;
    
    
    /**
     * Constructor for creating a receipt.  Takes all the information in the 
     * constructor and creates the first line item.  Subsequent line items created
     * in method below.
     * @param quantity - Contains the quantity of items passed from POSRegister.
     * @param productID - Contains the product ID of the items passed from POSRegister.
     * @param customerNumber - Contains the customer number passed from POSRegister
     * @param receiptStrategy - object of the ReceiptStrategy
     * @param database - object of the DatabaseStrategy
     */
    public Receipt(int quantity, String productID, String customerNumber, ReceiptStrategy receiptStrategy,
            DatabaseStrategy database){
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
        this.receiptStrategy = receiptStrategy;
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
        this.database = database;
        customer = database.getCustomerInformation(customerNumber);
        customer.addReceiptToHistory(receiptNumber);
        lineItem = new LineItem(database.getProductInformation(productID), quantity);
        lineItems[0] = lineItem;
    }
    
    /**
     * This method gets the receipt output from whatever class of the Receipt Strategy
     * that was passed in from the startup class
     */
    public final void outputReceiptStrategy(){
         receiptStrategy.generateReceipt(customer, lineItems, receiptNumber);
    }
    
    /**
     * Returns the receipt number
     * @return 
     */
    public final int getReceiptNumber() {
        return receiptNumber;
    }
    
    /**
     * Allows additional line items to be created for a receipt with multiple
     * purchases.
     * @param quantity - Contains the quantity of items passed from POSRegister.
     * @param productID - Contains the product ID of the items passed from POSRegister.
     */
    public final void addNewLineItem(int quantity, String productID){
        lineItem = new LineItem(database.getProductInformation(productID), quantity);
        LineItem [] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = lineItem;
        lineItems = tempArray;
    }
}
