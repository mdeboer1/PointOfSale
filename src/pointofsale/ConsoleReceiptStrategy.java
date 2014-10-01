/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class generates a receipt that is output to the console, and is an 
 * implementation of the ReceiptStrategy interface.  This class deliberately
 * violates a portion of the DIP as it receives a Customer and LineItem object as
 * arguments from the Receipt.  This was done intentionally to make the code
 * simpler to understand and easier to maintain because the only alternative
 * was to pass in all the data from the receipt!
 * @author mdeboer1
 * @version 1.00
 */
public class ConsoleReceiptStrategy implements ReceiptStrategy {

    private String storeName = "Kohl's Department Store";
    private String thankYou = "\n\t\tThank you for shopping at Kohl's!\n\n";
    private double grandTotalOfDiscount;
    private double subtotal;
    private double taxes = .051;
    private double taxAmount;
    private double grandTotal;
    
    /**
     * This class outputs a finalized receipt to the console.
     * @param customer - object passed to access customer information, is not 
     * stored locally in this class.
     * @param lineItems - array of all the lineItem objects, is not stored locally
     * in this class.
     * @param receiptNumber - receiptNumber passed to add to the receipt.
     */
    @Override
    public final void generateReceipt(Customer customer, LineItem [] lineItems, int receiptNumber) {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter= new SimpleDateFormat("MMM dd yyyy HH:mm:ss"); //format it as per your requirement
        String getTodaysDate = formatter.format(currentDate.getTime());
        System.out.println(storeName + "\n" + "Date: " + getTodaysDate + 
                "\nReceipt Number: " + receiptNumber);
        for (int i = 0; i <= lineItems.length - 1; i++){
            if (i == 0){
                grandTotalOfDiscount += lineItems[i].getAmountSavedPerLine();
                subtotal += lineItems[i].getExtendedPrice();
                System.out.println("Customer Number: " + customer.getCustomerNumber() +
                        "\n---------------------------------------------------------------\n");
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getProductPrice(), lineItems[i].getAmountSavedPerLine(), lineItems[i].getExtendedPrice());
            }
            if (i > 0 && (!(i > lineItems.length - 1))){
                grandTotalOfDiscount += lineItems[i].getAmountSavedPerLine();
                subtotal += lineItems[i].getExtendedPrice();
                System.out.printf("%s \t %s \t %d \t %.2f \t %.2f \t %.2f \n", lineItems[i].getProductNumber(),
                        lineItems[i].getProductDescription(), lineItems[i].getQuantity(),
                        lineItems[i].getProductPrice(), lineItems[i].getAmountSavedPerLine(), lineItems[i].getExtendedPrice());
            }
        }
        taxAmount = subtotal * taxes;
        grandTotal = subtotal + taxAmount;
        System.out.printf("\n\t\t\t\tTotal Saved: \t %.2f \n\t\t\t\tSubtotal: \t%.2f" +
          "\n\t\t\t\tTaxes: \t\t %.2f \n\t\t\t\tGrand Total: \t%.2f\n\t\t%s",
                grandTotalOfDiscount,subtotal,taxes,grandTotal, thankYou);
    }
}

