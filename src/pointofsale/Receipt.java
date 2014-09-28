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
    private String customerNumber;
    
    private LineItem [] lineItems = new LineItem[1];
    
    public Receipt(){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }
    
    public void setFirstLineItem(LineItem lineItem, Customer customer){
        if (lineItem == null){
            throw new IllegalArgumentException(
                    "error: lineItem cannot be null");
        }
        else if (customer == null){
            throw new IllegalArgumentException(
                    "error: customer cannot be null");
        }
        lineItems[0] = lineItem;
        this.customerNumber = customer.getCustomerNumber();
        customer.addReceiptToHistory(receiptNumber);
    }
    
    public void setNewLineItem(LineItem lineItem){
        if (lineItem == null){
            throw new IllegalArgumentException(
                    "error: lineItem cannot be null");
        }
        LineItem [] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = lineItem;
        lineItems = tempArray;
    }
    
    public String getReceipt(){
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
        System.out.printf("\n\t\t\t\tTotal Saved: \t %.2f \n\t\t\t\tSubtotal: \t%.2f\n" +
                "\t\t\t\tGrand Total: \t%.2f\n",grandTotalOfDiscount,subtotal,grandTotal);
//        System.out.println("\n\t\t\t\t\tTotal Saved: " + grandTotalOfDiscount +
//                "\n\t\t\t\t\tSubtotal: " + subtotal + "\n" + "\t\t\t\t\tTaxes: " + 
//                taxAmount + "\n\t\t\t\t\tGrand Total: " + grandTotal + "\n");        
//                
        return thankYou;
        
    }
}
