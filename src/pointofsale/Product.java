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
public class Product {
    private String productDescription;
    private String productCode;
    private double price;
    private String discountType;
    private DiscountStrategy discount;

    public Product(){
        
    }
    
    public Product(String description, String productCode, double price){
        setProductDescription(description);
        setProductCode(productCode);
        setPrice(price);
    }
    
    public Product(String description, String productCode, double price, DiscountStrategy discount){
        if (discount == null){
            throw new IllegalArgumentException(
                    "error: discount type is required and cannot be null");
        }
        setProductDescription(description);
        setProductCode(productCode);
        setPrice(price);
        this.discount = discount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.equals(" ")){
            if (productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
            }
        }
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    private void setProductCode(String productCode) {
        if (productCode == null || productCode.equals(" ")){
            if (productCode == null || productCode.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
            }
        }
        this.productCode = productCode;
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
        double tempVar;
        if (discount == null){
            tempVar = 0;
        }
        else{
            tempVar = discount.getDiscountAmount();
        }
        return tempVar;
    }
    
    public String getDiscountType(){
        return discountType;
    }
    
    public void changeDiscountType(String discountType){
        this.discountType = discountType;
    }
}
