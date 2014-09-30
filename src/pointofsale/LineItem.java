/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class creates each line item that is shown on the receipt. 
 * @author mdeboer1
 * @version 1.00 
 */
public class LineItem {
    private Product product;
    private int quantity;
    private double extendedPrice;
    private double amountSavedPerLineItem;
    private String productNumber;
    private String productDescription;
    private double price;
    private double discountAmount;
    
    /**
     * Custom constructor for making the line items.
     * @param product - Contains the product number.
     * @param quantity - Contains the quantity.
     */
    public LineItem(Product product, int quantity){
        this.product = product;
        setQuantity(quantity);
        setProductNumber(product.getProductCode());
        setProductDescription(product.getProductDescription());
        setDiscountAmount(product.getDiscountAmount());
        setQuantity(quantity);
        setPrice(product.getPrice());
        setAmountSavedPerLine();
        setExtendedPrice();
        
    }
    
    /**
     * Returns the extended price of the line item.
     * @return - extendedPrice.
     */
    public final double getExtendedPrice(){
        return extendedPrice;
    }
    
    private void setExtendedPrice(){
        extendedPrice = quantity * price - amountSavedPerLineItem;
    }
    
    /**
     * Returns the total amount saved per line
     * @return - amountSavedPerLineItem;
     */
    public final double getAmountSavedPerLine(){
        return amountSavedPerLineItem;
    }
    
    private void setAmountSavedPerLine(){
        if (discountAmount < 1){
            amountSavedPerLineItem = quantity * (discountAmount * price);
        }
        else if (discountAmount > 1){
            amountSavedPerLineItem = quantity * discountAmount;
        }
    }    
    
    /**
     * Gets the products price.
     * @return - returns the price of the product.
     */
    public final double getProductPrice(){
        return product.getPrice();
    }

    private void setQuantity(int quantity){
        if(quantity < 1){
            throw new IllegalArgumentException(
                    "error: quantity must be at least 1");
        }
        this.quantity = quantity;
    }

    /**
     * Returns the quantity purchased.
     * @return - returns quantity.
     */
    public final int getQuantity() {
        return quantity;
    }

    /**
     * Returns the product number.
     * @return - returns productNumber.
     */
    public final String getProductNumber() {
        return productNumber;
    }

    private void setProductNumber(String productNumber) {
        if (productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product number must be a valid String");
        }
        this.productNumber = productNumber;
    }

    /**
     * Returns the description of the product.
     * @return - returns productDescription.
     */
    public final String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
        }
        this.productDescription = productDescription;
    }

    /**
     * Returns the price of the product.
     * @return - returns price.
     */
    public final double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(
                    "error: price must be greater than zero");
        }
        this.price = price;
    }

    /**
     * Returns the discount amount of the product (not the DiscountStrategy object).
     * @return - returns the discountAmount.
     */
    public final double getDiscountAmount() {
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
