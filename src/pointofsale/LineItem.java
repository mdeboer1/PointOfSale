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
public class LineItem {
    private Product product;
    private int quantity;
    public LineItem(Product product, int quantity, Customer customer, Receipt receipt){
        this.product = product;
        setQuantity(quantity);
        receipt.setLineItem(quantity, product, customer, receipt);
        
    }
    
    public void getProductPrice(){
        product.getPrice();
    }
    
    private void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
