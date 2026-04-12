package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product coat = new DiscountedProduct("Пальто", 40, 90);
        Product ball = new FixPriceProduct("Мяч");
        Product sword = new DiscountedProduct("Меч", 100, 10);
        Product lock = new SimpleProduct("Замок", 60);

        productBasket.addProduct(coat);
        productBasket.addProduct(ball);
        productBasket.addProduct(coat); // второе пальто

        List<Product> remove = productBasket.removeProduct("Пальто");
        if (remove.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : remove) {
                System.out.println(p);
            }
        }
        System.out.println("Содержимое корзины после удаления:");
        productBasket.printBasket();
        System.out.println("=== Удаление несуществующего продукта ===");
        productBasket.removeProduct("Rat");
        System.out.println("Удалённые продукты:");
        if (productBasket.removeProduct("Rat").isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : productBasket.removeProduct("Rat")) {
                System.out.println(p);
            }
        }

        System.out.println("Содержимое корзины после удаления:");
        productBasket.printBasket();



        Article chocolateArtc = new Article("Вкусный чоколад", "Ну просто обьеденье");
        Article ballArtc = new Article("Мяч", "Упругий мячик");
        Article swordArtc = new Article("Меч", "Острый как бритва меч");

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(ball);
        searchEngine.add(coat);
        searchEngine.add(sword);
        searchEngine.add(lock);

        searchEngine.add(chocolateArtc);
        searchEngine.add(ballArtc);
        searchEngine.add(swordArtc);

        List<Searchable> found = searchEngine.search("Мяч");
        List<Searchable> found1 = searchEngine.search("Меч");
        System.out.println("Найдено: " + found);
        System.out.println("Найдено: " + found1);

//        try {
//            Searchable found = searchEngine.findSearchable("Мяч");
//            System.out.println("Найден объект: " + found.getStringRepresentation());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//        try {
//            Searchable found = searchEngine.findSearchable("gisdgfiosagj");
//            System.out.println("Найден объект: " + found.getStringRepresentation());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
    }
}
