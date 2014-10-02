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
 * product numbers.  It implements the DatabaseStrategy for DIP compliance since
 * it is a fake database to test out project.
 * @author mdeboer1
 * @version 1.00
 * 
 */
public class FakeDatabase implements DatabaseStrategy {
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
    public final void addCustomerInformation(String customerNumber){
        if (customerNumber == null ||customerNumber.equals(" ")){
             throw new IllegalArgumentException(
                    GlobalConstants.CUSTOMER_NUMBER_WARNING_MESSAGE);
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
    public final void addProductWithDiscount(String productDescription, String productNumber, double price, DiscountStrategy discount){
        if(productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_DESCRIPTION_WARNING_MESSAGE);
        }
        else if(productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        else if (price <= 0){
            throw new IllegalArgumentException(
                    GlobalConstants.PRICE_AMOUNT_WARNING_MESSAGE);
        }
        else if (discount == null){
            throw new IllegalArgumentException(
                    GlobalConstants.DISCOUNT_TYPE_WARNING_MESSAGE);
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
    public final void addProductWithoutDiscount(String productDescription, String productNumber, double price){
        if(productDescription == null || productDescription.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_DESCRIPTION_WARNING_MESSAGE);
        }
        else if(productNumber == null || productNumber.equals(" ")){
            throw new IllegalArgumentException(
                    GlobalConstants.PRODUCT_NUMBER_WARNING_MESSAGE);
        }
        else if (price <= 0){
            throw new IllegalArgumentException(
                    GlobalConstants.DISCOUNT_TYPE_WARNING_MESSAGE);
        }
        Product newProduct = new Product(productDescription, productNumber, price);
        Product[] tempArray = new Product[products.length + 1];
        System.arraycopy(products, 0, tempArray, 0, products.length);
        tempArray[products.length] = newProduct;
        products = tempArray;
    }
}
