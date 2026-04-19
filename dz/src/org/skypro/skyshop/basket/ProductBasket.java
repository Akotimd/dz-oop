package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    HashMap<String, ArrayList<Product>> product;

    public ProductBasket() {
        this.product = new HashMap<>();
    }

    public void addProduct(String newProduct, Product product) {
        this.product.computeIfAbsent(newProduct, k -> new ArrayList<>()).add(product);
    }

    public void printBasket() {
        int count = 0;
        for (String key : product.keySet()) {
            for (Product productBasket : product.get(key)) {
                if (productBasket != null) {
                    count++;
                    System.out.println(productBasket);
                }
            }
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        }
        System.out.printf("Итого: %.2f %n", getTotalCost());
        System.out.println("Специальных товаров: " + isSpecialProduct());
    }

    public double getTotalCost() {
        double price = 0;
        for (String key : product.keySet()) {
            for (Product productBasket : product.get(key)) {
                if (productBasket != null) {
                    price += productBasket.getPrice();
                }
            }
        }
        return price;
    }

    public boolean productExist(String productName) {
        for (String key : product.keySet())
            for (Product productBasket : product.get(key)) {
            if (productBasket != null && productBasket.getProductName().equals(productName)) {
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }

    public void removeAllProduct() {
        for (String key2 : product.keySet()) {
            product.get(key2).clear();
        }
    }

    public List<Product> removeProduct(String productName) {
        ArrayList<Product> removesProduct = new ArrayList<>();
        for (ArrayList<Product> product : product.values()) {
            product.removeIf(p -> {
                if (p.getProductName().equals(productName)) {
                    removesProduct.add(p);
                    System.out.println("Удалён продукт: " + p);
                    return true;
                }
                return false;
            });
        }
        return removesProduct;
    }

    public int isSpecialProduct() {
        int countIsSpec = 0;
        for (String key : product.keySet()) {
            for (Product productIsSpecial : product.get(key)) {
                if (productIsSpecial != null && productIsSpecial.isSpecial()) {
                    countIsSpec++;
                }
            }
        }
        return countIsSpec;
    }
}

