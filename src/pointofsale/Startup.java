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
public class Startup {
    public static void main(String[] args) {
        POSRegister register = new POSRegister();
        register.setFirstLineItem(1, "00004", "3");
        System.out.println(register.getReceipt());
        register.setNextLineItem(1, "00002", "3");
        System.out.println(register.getReceipt());
        
    }
    
}
