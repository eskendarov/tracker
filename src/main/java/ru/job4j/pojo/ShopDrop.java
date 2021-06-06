package ru.job4j.pojo;

/**
 * ShopDrop Class description goes here.
 *
 * @author Enver Eskendarov
 * @version 1.0 06/06/2021
 */
public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length-1; i++) {
            products[i] = products[i+1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
