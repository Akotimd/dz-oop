package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Шоколад", 20);
        Product product2 = new Product("Мяч", 30);
        Product product3 = new Product("Пальто", 40);
        Product product4 = new Product("Меч", 50);
        Product product5 = new Product("Замок", 60);
        Product product6 = new Product("Заз", 30);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6); // не добавляется видно на выводе
        basket.printBasket();
        System.out.println(("Итого: " + basket.costBasket()));
        basket.nameProduct("Мяч");
        basket.nameProduct("Курица");
        basket.removeAllProduct();
        basket.printBasket();
        System.out.println(("Итого: " + basket.costBasket()));
        basket.nameProduct("Курица");
    }
}
