package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    HashMap<String, ArrayList<Product>> product;

    public ProductBasket() {
        this.product = new HashMap<>();
    }

    public void addProduct(String newProduct, Product product) {
        this.product.computeIfAbsent(newProduct, k -> new ArrayList<>()).add(product);
    }

    public void printBasket() {
        List<Product> items = product.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (items.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            items.forEach(System.out::println);
        }
        System.out.printf("Итого: %.2f %n", getTotalCost());
        System.out.println("Специальных товаров: " + isSpecialProduct());
    }

    public double getTotalCost() {
        return product.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public boolean productExist(String productName) {
        return product.values().stream().
                flatMap(Collection::stream).
                anyMatch(p -> p != null && p.getName().equals(productName));
    }

    public void removeAllProduct() {
        product.values().stream().forEach(List::clear);
    }

    public List<Product> removeProduct(String productName) {
        ArrayList<Product> removesProduct = new ArrayList<>();
        product.values().stream().
                forEach(list -> list.removeIf(p -> {
            if (p.getName().equals(productName)) {
                removesProduct.add(p);
                System.out.println("Удалён продукт: " + p);
                return true;
            }
            return false;
        }));
        return removesProduct;
    }

    private int getSpecialCount() {
        return (int) product.values().stream().
                flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public int isSpecialProduct() {
        return getSpecialCount();
    }
}

