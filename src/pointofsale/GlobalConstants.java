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
public class GlobalConstants {
    public static final double MINIMUM_PRICE_ALLOWED = 0;
    public static final String PRODUCT_NUMBER_WARNING_MESSAGE = "error: product number must be a valid String";
    public static final String PRODUCT_DESCRIPTION_WARNING_MESSAGE = "error: product description must be a valid String";
    public static final String CUSTOMER_NUMBER_WARNING_MESSAGE ="error: customer number must be a valid String";
    public static final String PRICE_AMOUNT_WARNING_MESSAGE = "error: price must be greater than zero";
    public static final String DISCOUNT_TYPE_WARNING_MESSAGE = "error: type of discount must be an object";
    public static final String RECEIPT_NUMBER_WARNING_MESSAGE = "error: receiptNumber must be greater than zero";
    public static final String QUANTITY_WARNING_MESSAGE = "error: quantity must not be less than zero";
    public static final String RECEIPT_OBJECT_WARNING_MESSAGE = "error: receipt strategy cannot be null";
}
