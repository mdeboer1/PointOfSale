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
    
    public Receipt(){
        receiptNumber = receiptNumberIncrementer;
        receiptNumberIncrementer++;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }
    
    
}
