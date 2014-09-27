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
        register.setNextLineItem(1, "00002", "3");
        System.out.println(register.getReceipt());
        
//        POSRegister register2 = new POSRegister();
//        register2.setFirstLineItem(1, "00001", "2");
//        register2.setNextLineItem(1, "00002", "2");
//        register2.setNextLineItem(1, "00004", "2");
//        System.out.println(register2.getReceipt());
        
    }
    
}
