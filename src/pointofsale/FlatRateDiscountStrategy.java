/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author mdeboer1
 * This class implements the abstraction layer and is used for a specific dollar
 * amount of as a discount
 */
public class FlatRateDiscountStrategy implements DiscountStrategy {

    private double discountAmount = 5;
    
    public FlatRateDiscountStrategy(){
        
    }
    // Custom constructor created to allow discount amount to be changed
    public FlatRateDiscountStrategy(double discountAmount){
        setDiscountAmount(discountAmount);
    }
    // Used to change the discount amount
    private void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double getDiscountAmount() {
        return discountAmount;
    }
    
}
