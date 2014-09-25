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
public class FakeDataBase {
    private Customer customer1 = new Customer("1");
    private Customer customer2 = new Customer("2");
    private Customer customer3 = new Customer("3");
    private Customer customer4 = new Customer("4");
    private Customer [] customers = {customer1, customer2, customer3, customer4};
    private Product product1 = new Product("Hat", "0001", 19.95);
    private Product product2 = new Product("T-SHirt", "00002", 15.99);
    private Product product3 = new Product("Bath robe", "00003", 39.95);
    private Product product4 = new Product("Mixer", "00004", 399.99);
    private Product[] products = {product1, product2, product3, product4};

    public FakeDataBase(){
        
    }
    
    public Product getProductDescription(String productNumber){
        int index = 0;
        for(int i = 0; i <= products.length - 1 ; i++){
            if (productNumber.equals(products[i].getProductCode())){
                index = i;
            }
        }
        return products[index];
    }
    
    public Customer getCustomerInformation(String customerNumber){
        int index = 0;
        for(int i = 0; i <= customers.length - 1; i++){
            if (customerNumber.equals(customers[i].getCustomerNumber())){
                index = i;
            }
        }
        return customers[index];
    }    
    
    public void addCustomerToArray(String customerNumber){
        Customer newCustomer = new Customer(customerNumber);
        Customer[] tempArray = new Customer[customers.length + 1];
        System.arraycopy(customers, 0, tempArray, 0, customers.length);
        tempArray[customers.length] = newCustomer;
        customers = tempArray;
    }
    
    public void addProductToArray(String productDescription, String productNumber, double price){
        Product newProduct = new Product(productDescription, productNumber, price);
        Product[] tempArray = new Product[products.length + 1];
        System.arraycopy(products, 0, tempArray, 0, products.length);
        tempArray[products.length] = newProduct;
        products = tempArray;
    }
    
}
