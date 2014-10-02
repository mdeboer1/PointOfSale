/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This is the startup class to test and run the POS project.
 * @author mdeboer1
 * @version 1.00
 * 
 */
public class Startup {
    
    public static void main(String[] args) {

        POSRegister register = new POSRegister(1, "00004", "3", 
                new ConsoleReceiptStrategy(), new FakeDatabase());
        register.addNewLineItem(1, "00002");
        register.generateConsoleReceipt();
        
        POSRegister register2 = new POSRegister(1, "00001", "2", 
                new ConsoleReceiptStrategy(), new FakeDatabase());
        register2.addNewLineItem(1, "00002");
        register2.addNewLineItem(1, "00003");
        register2.generateConsoleReceipt();
    }
}
