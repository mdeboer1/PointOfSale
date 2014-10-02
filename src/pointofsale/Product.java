/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class creates and stores the information for the products.
 * @author mdeboer1
 * @version 1.00
 */
public class Product {
    private String productDescription;
    private String productCode;
    private double price;
    private DiscountStrategy discount;
    
    /**
     * Constructor for creating products that have no discounts at time of creation
     * @param description - description of product
     * @param productCode - unique product identifier
     * @param price - Price of the specific product 
     * @throws - description and product code must be !null or empty, price must
     * be < zero, and DiscountStrategy cannot be null
     */
    public Product(String description, String productCode, double price){
        if (description == null || description.equals(" ")){
             throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_DESCRIPTION_WARNING_MESSAGE);
        }
        if (productCode == null || productCode.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        else if (price <= GlobalConstants.MINIMUM_PRICE_ALLOWED ){
            throw new IllegalArgumentException(
                    GlobalConstants.PRICE_AMOUNT_WARNING_MESSAGE);
        }
        setProductDescription(description);
        setProductCode(productCode);
        setPrice(price);
    }
    
    /**
     * Constructor for creating products that have a discount at time of creation
     * @param description - description of product
     * @param productCode - unique product identifier
     * @param price - Price of the specific product
     * @param discount - DIP compliant DiscountStrategy object
     * @throws - description and product code must be !null or empty, price must
     * be < zero, and DiscountStrategy cannot be null
     */
    public Product(String description, String productCode, double price, DiscountStrategy discount){
        if (description == null || description.equals(" ")){
             throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_DESCRIPTION_WARNING_MESSAGE);
        }
        if (productCode == null || productCode.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        else if (price <= GlobalConstants.MINIMUM_PRICE_ALLOWED ){
            throw new IllegalArgumentException(
                    GlobalConstants.PRICE_AMOUNT_WARNING_MESSAGE);
        }
        if (discount == null){
            throw new IllegalArgumentException(
                    GlobalConstants.DISCOUNT_TYPE_WARNING_MESSAGE);
        }
        setProductDescription(description);
        setProductCode(productCode);
        setPrice(price);
        this.discount = discount;
    }
    /**
     * Returns the description of the product
     * @return 
     */
    public String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_DESCRIPTION_WARNING_MESSAGE);
       }
        this.productDescription = productDescription;
    }
    
    /**
     * Returns the product code
     * @return 
     */
    public final String getProductCode() {
        return productCode;
    }

    private void setProductCode(String productCode) {
        if (productCode == null || productCode.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        this.productCode = productCode;
    }

    public final double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= GlobalConstants.MINIMUM_PRICE_ALLOWED){
            throw new IllegalArgumentException(
                    GlobalConstants.PRICE_AMOUNT_WARNING_MESSAGE);
        }
        this.price = price;
    }
    
    /**
     * returns the discount amount.  tempVar parameter used to locally store
     * the discount amount so it can be returned to calling class.
     *  @return - returns the discount amount (in dollars or percentage
     * depending on the DiscountStrategy type being used (if any)!
     */
    public final double getDiscountAmount() {
        double tempVar;
        if (discount == null){
            tempVar = 0;
        }
        else{
            tempVar = discount.getDiscountAmount();
        }
        return tempVar;
    }
}
