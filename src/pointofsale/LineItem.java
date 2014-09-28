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
    
    private double discountAmount;
    
    public LineItem(Product product, int quantity, Receipt receipt){
        this.product = product;
        setQuantity(quantity);
        setProductNumber(product.getProductCode());
        setProductDescription(product.getProductDescription());
        setDiscountAmount(product.getDiscountAmount());
        setQuantity(quantity);
        setPrice(product.getPrice());
    }
    
    public void getProductPrice(){
        product.getPrice();
    }
    
    private void setQuantity(int quantity){
        if(quantity < 1){
            throw new IllegalArgumentException(
                    "error: quantity must be at least 1");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductNumber() {
        return productNumber;
    }

    private void setProductNumber(String productNumber) {
        if (productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product number must be a valid String");
        }
        this.productNumber = productNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
        }
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(
                    "error: price must be greater than zero");
        }
        this.price = price;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    private void setDiscountAmount(double discountAmount) {
        if (discountAmount < 0){
            throw new IllegalArgumentException(
                    "error: discount must be atleast zero or higher");
        }
        this.discountAmount = discountAmount;
    }
    
    
}
