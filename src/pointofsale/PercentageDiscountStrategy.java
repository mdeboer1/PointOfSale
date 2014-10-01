/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class implements the abstraction layer and is used to add a percentage
 * discount to a product
 * @author mdeboer1
 * @version 1.00
 */
public class PercentageDiscountStrategy implements DiscountStrategy{

    private double discountAmount = .15;
    
    /**
     * Default constructor provided in case percentage amount doesn't need overriding
     * from the predetermined amount above.
     */
    public PercentageDiscountStrategy() {
        
    }
    
    /**
     * This is a custom constructor that allows the discount amount to be overridden
     * if necessary when PercentageDiscountStrategy object is created.
     * @param discountAmount - stores discount amount
     */
    public PercentageDiscountStrategy(double discountAmount){
        setDiscountAmount(discountAmount);
    }

    private void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * This is the overridden method from DiscountStrategy.  It returns the 
     * discount amount.
     * @return - returns discountAmount
     */
    @Override
    public final double getDiscountAmount() {
        return discountAmount;
    }
    
}
