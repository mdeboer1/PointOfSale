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
    private double discountAmount;
    private DiscountStrategy discount;
    private DiscountStrategy[] discountTypeArray = {new PercentageDiscountStrategy(),
        new FlatRateDiscountStrategy()};
    private String [] discounts = {"Percent", "Flat Rate"};
    public Product(){
        
    }
    
    public Product(String description, String productCode, double price, String discountType){
        setProductDescription(description);
        setProductCode(productCode);
        setPrice(price);
        setDiscountType(discountType);
    }

    public String getProductDescription() {
        return productDescription;
    }

    private void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    private void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountAmount() {
        return discountAmount = discount.getDiscountAmount();
    }

    public void setDiscountType(String discountType) {
        // For loop for arrays to determine the type of discount.
        this.discountType = discountType;
        for(int i = 0; i <= discounts.length-1; i++){
            if (discountType.equals(discounts[i])){
                discount = discountTypeArray[i];
            }
        }
    }
    
    public void addDiscountRateType(DiscountStrategy discount, String discountType){
        //Expand discountTypeArray
        DiscountStrategy newStrategy = discount;
        DiscountStrategy [] tempArray = new DiscountStrategy[discountTypeArray.length +1];
        System.arraycopy(discountTypeArray, 0, tempArray, 0, discountTypeArray.length);
        tempArray[discountTypeArray.length] = newStrategy;
        discountTypeArray = tempArray;
        
        // Expand discounts array
        String [] tempItems = new String[discounts.length + 1];
        System.arraycopy(discounts, 0, tempItems, 0, discounts.length);
        tempItems[discounts.length] = discountType;
        discounts = tempItems;
    }
}
