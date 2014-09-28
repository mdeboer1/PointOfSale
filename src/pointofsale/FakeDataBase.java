/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author mdeboer1
 * This class is used to simulate a database.  It creates four customers and four
 * product objects, stores them in arrays, and then sorts through to match the
 * information passed from the POSRegister class to select the correct customer and
 * product numbers.
 */
public class FakeDataBase {
    private Customer customer1 = new Customer("1");
    private Customer customer2 = new Customer("2");
    private Customer customer3 = new Customer("3");
    private Customer customer4 = new Customer("4");
    private Customer [] customers = {customer1, customer2, customer3, customer4};
    private Product product1 = new Product("Hat    ", "00001", 19.95, new PercentageDiscountStrategy());
    private Product product2 = new Product("T-Shirt", "00002", 15.99);
    private Product product3 = new Product("Robe   ", "00003", 39.95, new FlatRateDiscountStrategy());
    private Product product4 = new Product("Jeans  ", "00004", 59.95, new PercentageDiscountStrategy());
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
        if (customerNumber == null ||customerNumber.equals(" ")){
             throw new IllegalArgumentException(
                    "error: custemer number must be a valid String");
        }
        Customer newCustomer = new Customer(customerNumber);
        Customer[] tempArray = new Customer[customers.length + 1];
        System.arraycopy(customers, 0, tempArray, 0, customers.length);
        tempArray[customers.length] = newCustomer;
        customers = tempArray;
    }
    
    public void addProductToArrayWithDiscount(String productDescription, String productNumber, double price, DiscountStrategy discount){
        if(productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
        }
        else if(productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product number must be a valid String");
        }
        else if (price <= 0){
            throw new IllegalArgumentException(
                    "error: price must be greater than zero");
        }
        else if (discount == null){
            throw new IllegalArgumentException(
                    "error: type of discount must be an object");
        }
        Product newProduct = new Product(productDescription, productNumber, price, discount);
        Product[] tempArray = new Product[products.length + 1];
        System.arraycopy(products, 0, tempArray, 0, products.length);
        tempArray[products.length] = newProduct;
        products = tempArray;
    }
    
    public void addProductToArrayWithoutDiscount(String productDescription, String productNumber, double price){
        if(productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product description must be a valid String");
        }
        else if(productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    "error: product number must be a valid String");
        }
        else if (price <= 0){
            throw new IllegalArgumentException(
                    "error: price must be greater than zero");
        }
        Product newProduct = new Product(productDescription, productNumber, price);
        Product[] tempArray = new Product[products.length + 1];
        System.arraycopy(products, 0, tempArray, 0, products.length);
        tempArray[products.length] = newProduct;
        products = tempArray;
    }
}
