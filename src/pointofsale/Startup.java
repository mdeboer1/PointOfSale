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
        POSRegister register = new POSRegister(1, "0001", "2");
    
        System.out.println(register.getReceipt());
    }
    
}
