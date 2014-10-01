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
    
    /**
     * Custom constructor for making the line items.
     * @param product - Contains the product number.
     * @param quantity - Contains the quantity.
     */
    public LineItem(Product product, int quantity){
        this.product = product;
        setQuantity(quantity);
//        setProductNumber(product.getProductCode());
//        setProductDescription(product.getProductDescription());
//        setDiscountAmount(product.getDiscountAmount());
        setQuantity(quantity);
//        setPrice(product.getPrice());
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
//        extendedPrice = quantity * price - amountSavedPerLineItem;
        extendedPrice = quantity * product.getPrice() - amountSavedPerLineItem;
    }
    
    /**
     * Returns the total amount saved per line
     * @return - amountSavedPerLineItem;
     */
    public final double getAmountSavedPerLine(){
        return amountSavedPerLineItem;
    }
    
    private void setAmountSavedPerLine(){
        if (product.getDiscountAmount() < 1){
            amountSavedPerLineItem = quantity * (product.getDiscountAmount() * product.getPrice());
        }
        else if (product.getDiscountAmount() > 1){
            amountSavedPerLineItem = quantity * getDiscountAmount();
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
     * Returns the discount amount of the product (not the DiscountStrategy object).
     * @return - returns the discountAmount.
     */
    public final double getDiscountAmount() {
        return product.getDiscountAmount();
    }
    
    /**
     * This getter provided so receipt is able to retrieve the product description
     * from the lineItem since receipt should not know about the product directly.
     * @return 
     */
    public final String getProductDescription(){
        return product.getProductDescription();
    }
    
    /**
     * This getter provided so receipt is able to retrieve the product number
     * from the lineItem since receipt should not know about the product directly.
     * @return 
     */
    public final String getProductNumber(){
        return product.getProductCode();
    }
}
