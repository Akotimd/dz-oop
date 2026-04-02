package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product ball = new FixPriceProduct("Мяч");
        Product coat = new DiscountedProduct("Пальто", 40, 90);
        Product sword = new DiscountedProduct("Меч", 100, 10);
        Product lock = new SimpleProduct("Замок", 60);

        Article chocolateArtc = new Article("Вкусный чоколад", "Ну просто обьеденье");
        Article ballArtc = new Article("Мяч", "Упругий мячик");
        Article swordArtc = new Article("Меч", "Острый как бритва меч");
        try {
            Product chocolate = new DiscountedProduct("Шоколад", -1, 101);
            System.out.println("Всё норм");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении товара");
        }

        productBasket.addProduct(ball);
        productBasket.addProduct(coat);
        productBasket.addProduct(sword);
        productBasket.addProduct(lock);
        productBasket.printBasket();

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(ball);
        searchEngine.add(coat);
        searchEngine.add(sword);
        searchEngine.add(lock);

        searchEngine.add(chocolateArtc);
        searchEngine.add(ballArtc);
        searchEngine.add(swordArtc);


        Searchable[] test1 = searchEngine.search("Мяч");
        System.out.println(Arrays.toString(test1));
        Searchable[] test2 = searchEngine.search("Острый");
        System.out.println(Arrays.toString(test2));
        Searchable[] test3 = searchEngine.search("Меч");
        System.out.println(Arrays.toString(test3));

        System.out.println(ballArtc.getStringRepresentation());
    }
}
