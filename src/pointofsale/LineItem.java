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
    private String productNumber;
    private String productDescription;
    private double price;
    private String customerNumber;
    private double discountAmount;
    
    public LineItem(Product product, int quantity, Customer customer, Receipt receipt){
        this.product = product;
        setQuantity(quantity);
        this.productNumber = product.getProductCode();
        this.productDescription = product.getProductDescription();
        this.discountAmount = product.getDiscountAmount();
        this.quantity = quantity;
        this.price = product.getPrice();
        this.customerNumber = customer.getCustomerNumber();
        this.discountAmount = product.getDiscountAmount();
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

    public String getProductNumber() {
        return productNumber;
    }

    private void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    private void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    private void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    
}
