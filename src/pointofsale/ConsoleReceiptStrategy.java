/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *Not a used class as of this version
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
    private String customerNumber;
    
    @Override
    public void generateReceipt(Customer customer, LineItem [] lineItems, int receiptNumber) {
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
          "\n\t\t\t\tTaxes: \t\t %.2f \n\t\t\t\tGrand Total: \t%.2f\n\t\t%s",
                grandTotalOfDiscount,subtotal,taxes,grandTotal, thankYou);
    }
}

