/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private String storeName = "Kohl's Department Store";
    private String thankYou = "\n\t\tThank you for shopping at Kohl's!\n\n";
    private double extendedPrice;
    private double amountSavedPerLineItem;
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
    public Receipt(int quantity, String productID, String customerNumber){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
        database = new FakeDataBase();
        customer = database.getCustomerInformation(customerNumber);
        this.customerNumber = customer.getCustomerNumber();
        customer.addReceiptToHistory(receiptNumber);
        lineItem = new LineItem(database.getProductDescription(productID), quantity);
        lineItems[0] = lineItem;
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
        if (lineItem == null){
            throw new IllegalArgumentException(
                    "error: lineItem cannot be null");
        }
        lineItem = new LineItem(database.getProductDescription(productID), quantity);
        LineItem [] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = lineItem;
        lineItems = tempArray;
    }
    
    /**
     * Returns a fully formatted console receipt.
     * @return 
     */
    public final String getConsoleReceipt(){
//        NumberFormat nf = NumberFormat.getCurrencyInstance();
//        DecimalFormat df = new DecimalFormat("#0.00");
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter= new SimpleDateFormat("MMM dd yyyy HH:mm:ss"); //format it as per your requirement
        String getTodaysDate = formatter.format(currentDate.getTime());
        System.out.println(storeName + "\n" + "Date: " + getTodaysDate + 
                "\nReceipt Number: " + receiptNumber);
        for (int i = 0; i <= lineItems.length - 1; i++){
            if (i == 0){
                if (lineItems[i].getDiscountAmount() < 1){
                    amountSavedPerLineItem = (lineItems[i].getDiscountAmount() * 
                            (lineItems[i].getPrice() * lineItems[i].getQuantity()));
                }
                else {
                    amountSavedPerLineItem = (lineItems[i].getDiscountAmount() * 
                            lineItems[i].getQuantity());
                }
                grandTotalOfDiscount += amountSavedPerLineItem;
                extendedPrice = (lineItems[i].getPrice() * lineItems[i].getQuantity()) 
                        - amountSavedPerLineItem;
                subtotal += extendedPrice;
//                nf.format(amountSavedPerLineItem);
//                nf.format(grandTotalOfDiscount);
//                nf.format(extendedPrice);
//                nf.format(subtotal);
//                df.format(amountSavedPerLineItem);
//                df.format(grandTotalOfDiscount);
//                df.format(extendedPrice);
//                df.format(subtotal);    
                System.out.println("Customer Number: " + customerNumber +
                        "\n---------------------------------------------------------------\n");
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getPrice(), amountSavedPerLineItem, extendedPrice);
//                System.out.println("\nCustomer Number: " + lineItems[i].getCustomerNumber() +
//                        "\n---------------------------------------------------------------\n" +
//                        lineItems[i].getProductNumber() + "\t" + lineItems[i].getProductDescription() + 
//                        "\t" + lineItems[i].getQuantity() + "\t" + lineItems[i].getPrice() + 
//                        "\t" + amountSavedPerLineItem + "\t" + extendedPrice);
            }
            if (i > 0 && (!(i > lineItems.length - 1))){
                if (lineItems[i].getDiscountAmount() < 1){
                    amountSavedPerLineItem = (lineItems[i].getDiscountAmount() * 
                            (lineItems[i].getPrice() * lineItems[i].getQuantity()));
                }
                else {
                    amountSavedPerLineItem = (lineItems[i].getDiscountAmount() * 
                            lineItems[i].getQuantity());
                }
                grandTotalOfDiscount += amountSavedPerLineItem;
                extendedPrice = (lineItems[i].getPrice() * lineItems[i].getQuantity()) 
                        - amountSavedPerLineItem;
                subtotal += extendedPrice;
//                nf.format(amountSavedPerLineItem);
//                nf.format(grandTotalOfDiscount);
//                nf.format(extendedPrice);
//                nf.format(subtotal);
//                df.format(amountSavedPerLineItem);
//                df.format(grandTotalOfDiscount);
//                df.format(extendedPrice);
//                df.format(subtotal);
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getPrice(), amountSavedPerLineItem, extendedPrice);
//                System.out.println(lineItems[i].getProductNumber() + "\t" + lineItems[i].getProductDescription() 
//                    + "\t" + lineItems[i].getQuantity() + "\t" + lineItems[i].getPrice() + 
//                    "\t" + amountSavedPerLineItem + "\t" + extendedPrice);
            }
        }
        taxAmount = subtotal * taxes;
        grandTotal = subtotal + taxAmount;
//        nf.format(taxes);
//        nf.format(taxAmount);
//        nf.format(grandTotal);
//        df.format(taxes);
//        df.format(taxAmount);
//        df.format(grandTotal);
        System.out.printf("\n\t\t\t\tTotal Saved: \t %.2f \n\t\t\t\tSubtotal: \t%.2f" +
          "\n\t\t\t\tTaxes: \t\t %.2f \n\t\t\t\tGrand Total: \t%.2f\n",grandTotalOfDiscount,subtotal,taxes,grandTotal);
//        System.out.println("\n\t\t\t\t\tTotal Saved: " + grandTotalOfDiscount +
//                "\n\t\t\t\t\tSubtotal: " + subtotal + "\n" + "\t\t\t\t\tTaxes: " + 
//                taxAmount + "\n\t\t\t\t\tGrand Total: " + grandTotal + "\n");        
//                
        return thankYou;
        
    }
}
