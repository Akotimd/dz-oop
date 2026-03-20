package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Шоколад", 20);
        Product product2 = new FixPriceProduct("Мяч");
        Product product3 = new DiscountedProduct("Пальто", 40, 10);
        Product product4 = new DiscountedProduct("Меч", 100, 10);
        Product product5 = new SimpleProduct("Замок", 60);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.printBasket();

    }
}
