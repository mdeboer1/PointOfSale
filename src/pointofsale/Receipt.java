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
 *
 * @author mdeboer1
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
//        NumberFormat nf = NumberFormat.getCurrencyInstance();
//        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter= new SimpleDateFormat("MMM dd yyyy HH:mm:ss"); //format it as per your requirement
        String getTodaysDate = formatter.format(currentDate.getTime());
        System.out.println(storeName + "\n" + "Date: " + getTodaysDate + 
                "\nReceipt Number: " + receiptNumber);
//        String firstLineItem = "";
//        String nextLineItem = " ";
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
                
                System.out.println("\nCustomer Number: " + lineItems[i].getCustomerNumber() +
                        "\n---------------------------------------------------------------\n" +
                        lineItems[i].getProductNumber() + "\t" + lineItems[i].getProductDescription() + 
                        "\t" + lineItems[i].getQuantity() + "\t" + lineItems[i].getPrice() + 
                        "\t" + amountSavedPerLineItem + "\t" + extendedPrice + "\n");
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
                System.out.println(lineItems[i].getProductNumber() + "\t" + lineItems[i].getProductDescription() 
                    + "\t" + lineItems[i].getQuantity() + "\t" + lineItems[i].getPrice() + 
                    "\t" + amountSavedPerLineItem + "\t" + extendedPrice + "\n");
            }
        }
        taxAmount = subtotal * taxes;
        grandTotal = subtotal + taxAmount;
        String receiptTotals = "\n\t\t\t\t\tTotal Saved: " + grandTotalOfDiscount +
                "\n\t\t\t\t\tSubtotal: " + subtotal + "\n" + "\t\t\t\t\tTaxes: " + 
                taxAmount + "\n\t\t\t\t\tGrand Total: " + grandTotal + "\n";        
                
        return receiptTotals + thankYou;
        
    }
}
