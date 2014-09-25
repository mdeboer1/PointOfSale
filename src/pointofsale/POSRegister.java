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
public class POSRegister {
    private Receipt receipt;
    private FakeDataBase database;
    private LineItem lineItem;
    private Product product;
    
    public POSRegister(double quanity, int productID, int customerNumber){
        //Create new Receipt object
        this.receipt = new Receipt();
        //Create new FakeDataBase object to reference productID and customerNumber
        this.database = new FakeDataBase();
        //Create new product object to retrieve discount information
        this.product = new Product();
        //Create new LineItem object to hold line item information
        this.lineItem = new LineItem();
        
        
    }

    public int getReceiptNumber() {
        return receipt.getReceiptNumber();
    }
    
    
}    
