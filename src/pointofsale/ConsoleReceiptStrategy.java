/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mdeboer1
 */
public class ConsoleReceiptStrategy implements ReceiptStrategy {
    //Static variable to count number of objects created, to be used for receiptNumber property
    public static int receiptNumberIncrementer = 1;
    private final int receiptNumber;
    private String storeName = "Kohl's Department Store";
    private String thankYou = "\n\t\tThank you for shopping at Kohl's!\n\n";
    private double grandTotalOfDiscount;
    private double subtotal;
    private double taxes = .051;
    private double taxAmount;
    private double grandTotal;
    private String customerNumber;
    private LineItem [] lineItems = new LineItem[1];
    private FakeDataBase database;
    private LineItem lineItem;
    private Customer customer;
    
    /**
     * Constructor for creating a receipt.  Takes all the information in the 
     * constructor and creates the first line item.  Subsequent line items created
     * in method below.
     * @param quantity - Contains the quantity of items passed from POSRegister.
     * @param productID - Contains the product ID of the items passed from POSRegister.
     * @param customerNumber - Contains the customer number passed from POSRegister
     */
    public ConsoleReceiptStrategy(int quantity, String productID, String customerNumber){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
        database = new FakeDataBase();
        customer = database.getCustomerInformation(customerNumber);
        this.customerNumber = customer.getCustomerNumber();
        customer.addReceiptToHistory(receiptNumber);
//        product = database.getProductInformation(productID);
        lineItem = new LineItem(database.getProductInformation(productID), quantity);
        lineItems[0] = lineItem;
    }
    
    @Override
    /**
     * Allows additional line items to be created for a receipt with multiple
     * purchases.
     * @param quantity - Contains the quantity of items passed from POSRegister.
     * @param productID - Contains the product ID of the items passed from POSRegister.
     */
    public final void addNewLineItem(int quantity, String productID){
        if (lineItem == null){
            throw new IllegalArgumentException(
                    "error: lineItem cannot be null");
        }
        lineItem = new LineItem(database.getProductInformation(productID), quantity);
        LineItem [] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = lineItem;
        lineItems = tempArray;
    }

    @Override
    /**
     * Returns a fully formatted console receipt.
     * @return 
     */
    public final String getReceipt(){
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter= new SimpleDateFormat("MMM dd yyyy HH:mm:ss"); //format it as per your requirement
        String getTodaysDate = formatter.format(currentDate.getTime());
        System.out.println(storeName + "\n" + "Date: " + getTodaysDate + 
                "\nReceipt Number: " + receiptNumber);
        for (int i = 0; i <= lineItems.length - 1; i++){
            if (i == 0){
                grandTotalOfDiscount += lineItems[i].getAmountSavedPerLine();
                subtotal += lineItems[i].getExtendedPrice();
                System.out.println("Customer Number: " + customerNumber +
                        "\n---------------------------------------------------------------\n");
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getPrice(), lineItems[i].getAmountSavedPerLine(), lineItems[i].getExtendedPrice());
            }
            if (i > 0 && (!(i > lineItems.length - 1))){
                grandTotalOfDiscount += lineItems[i].getAmountSavedPerLine();
                subtotal += lineItems[i].getExtendedPrice();
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getPrice(), lineItems[i].getAmountSavedPerLine(), lineItems[i].getExtendedPrice());
            }
        }
        taxAmount = subtotal * taxes;
        grandTotal = subtotal + taxAmount;
        System.out.printf("\n\t\t\t\tTotal Saved: \t %.2f \n\t\t\t\tSubtotal: \t%.2f" +
          "\n\t\t\t\tTaxes: \t\t %.2f \n\t\t\t\tGrand Total: \t%.2f\n",grandTotalOfDiscount,subtotal,taxes,grandTotal);
        return thankYou;
    }

    @Override
    /**
     * Returns the receipt number
     * @return 
     */
    public final int getReceiptNumber() {
        return receiptNumber;
    }
    
}
