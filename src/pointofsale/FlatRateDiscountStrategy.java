/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class implements the abstraction layer and is used for a specific dollar
 * amount of as a discount
 * @author mdeboer1
 * @version 1.00
 */
public class FlatRateDiscountStrategy implements DiscountStrategy {

    private double discountAmount = 5;
 
    /**
     * Default constructor provided in case flat rate amount doesn't need overriding
     * from the predetermined amount above.
     */
    public FlatRateDiscountStrategy(){
        
    }
    
    /**
     * This is a custom constructor that allows the discount amount to be overridden
     * if necessary when FlatRateDiscountStrategy object is created.
     * @param discountAmount - stores discountAmount
     */
    public FlatRateDiscountStrategy(double discountAmount){
        setDiscountAmount(discountAmount);
    }
    
    private void setDiscountAmount(double discountAmount) {
        if(discountAmount < 0){
            throw new IllegalArgumentException(
                    GlobalConstants.DISCOUNT_AMOUNT_WARNING_MESSAGE);
        }
        this.discountAmount = discountAmount;
    }

    /**
     * This is the overridden method from DiscountStrategy.  It returns the 
     * discount amount.
     * @return - returns discoutAmount
     */
    @Override
    public final double getDiscountAmount() {
        return discountAmount;
    }
    
}
