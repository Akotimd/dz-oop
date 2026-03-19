package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Шоколад", 20);
        Product product2 = new SimpleProduct("Мяч", 30);
        Product product3 = new SimpleProduct("Пальто", 40);
        Product product4 = new SimpleProduct("Меч", 50);
        Product product5 = new SimpleProduct("Замок", 60);
        Product product6 = new SimpleProduct("Заз", 30);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6); // не добавляется видно на выводе
        basket.printBasket();
        System.out.println(("Итого: " + basket.getTotalCost()));
        basket.productExist("Мяч");
        basket.productExist("Курица");
        basket.removeAllProduct();
        basket.printBasket();
        System.out.println(("Итого: " + basket.getTotalCost()));
        basket.productExist("Курица");
    }
}
