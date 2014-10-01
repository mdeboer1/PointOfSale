/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 * This class is used to simulate a database.  It creates four customers and four
 * product objects, stores them in arrays, and then sorts through to match the
 * information passed from the POSRegister class to select the correct customer and
 * product numbers.
 * @author mdeboer1
 * @version 1.00
 * 
 */
public class FakeDataBase implements DatabaseStrategy {
    private Customer [] customers = {new Customer("1"), new Customer("2"), new Customer("3"), new Customer("4")};
    private Product[] products = {new Product("Hat    ", "00001", 19.95, new PercentageDiscountStrategy()),
            new Product("T-Shirt", "00002", 15.99), new Product("Robe   ", "00003", 39.95, new FlatRateDiscountStrategy())
            , new Product("Jeans  ", "00004", 59.95, new PercentageDiscountStrategy())};
    
    /**
     * This method receives a product number and iterates through the products
     * array to match the product being purchased.
     * @param productNumber - Contains the product number to be matched.
     * @return - returns Product object.
     */
    @Override
    public final Product getProductInformation(String productNumber){
        int index = 0;
        for(int i = 0; i <= products.length - 1 ; i++){
            if (productNumber.equals(products[i].getProductCode())){
                index = i;
            }
        }
        return products[index];
    }
    
    /**
     * This method receives a customer number and iterates through the customers
     * array to match the customer who is making the purchase.
     * @param customerNumber - Contains the customer number to be matched.
     * @return - returns Customer object.
     */
    @Override
    public final Customer getCustomerInformation(String customerNumber){
        int index = 0;
        for(int i = 0; i <= customers.length - 1; i++){
            if (customerNumber.equals(customers[i].getCustomerNumber())){
                index = i;
            }
        }
        return customers[index];
    }    
    
    /**
     * Allows a new customer to be added to the customers array.
     * @param customerNumber - Contains the customer number to be added.
     */
    public final void addCustomerToArray(String customerNumber){
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
    
    /**
     * Allows a product with a DiscountStrategy to be added to the products array.
     * @param productDescription - Contains the description of the product.
     * @param productNumber - Contains the product number.
     * @param price - Contains the price of the product.
     * @param discount - Contains the DiscountStrategy object.
     */
    public final void addProductToArrayWithDiscount(String productDescription, String productNumber, double price, DiscountStrategy discount){
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
    
    /**
     * This allows a product without a preset DiscountStrategy to be added to products array.
     * @param productDescription - Contains the description of the product.
     * @param productNumber - Contains the product number.
     * @param price - Contains the price of the product. 
     */
    public final void addProductToArrayWithoutDiscount(String productDescription, String productNumber, double price){
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
