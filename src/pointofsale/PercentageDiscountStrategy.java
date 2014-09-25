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
public class PercentageDiscountStrategy implements DiscountStrategy{

    private double discountAmount = .15;
    
    public PercentageDiscountStrategy() {
        
    }
    
    public PercentageDiscountStrategy(double discountAmount){
        setDiscountAmount(discountAmount);
    }

    private void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double getDiscountAmount() {
        return discountAmount;
    }
    
}
