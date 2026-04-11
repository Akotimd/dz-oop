package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    ArrayList<Product> product;

    public ProductBasket() {
        this.product = new ArrayList<>();
    }

    public void addProduct(Product newProduct) {
        this.product.add(newProduct);
    }

    public void printBasket() {
        int count = 0;
        for (Product productBasket : product) {
            if (productBasket != null) {
                count++;
                System.out.println(productBasket);
            }
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        }
        System.out.println(String.format("Итого: %.2f ", getTotalCost()));
        System.out.println("Специальных товаров: " + isSpecialProduct());
    }

    public double getTotalCost() {
        double price = 0;
        for (double i = 0; i < product.toArray().length; i++) {
            if (product.get((int) i) != null) {
                price += product.get((int) i).getPrice();
            }
        }
        return price;
    }

    public boolean productExist(String productName) {
        for (Product productBasket : product) {
            if (productBasket != null && productBasket.getProductName().equals(productName)) {
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;
    }

    public void removeAllProduct() {
        for (int i = 0; i < product.toArray().length; i++) {
            product.set(i, null);
        }
    }

//    public List removeProduct(Product name) {
//        for (int i = 0; i < product.toArray().length; i++) {
//
//        }
//        return
//    }

    public int isSpecialProduct() {
        int countIsSpec = 0;
        for (Product productIsSpecial : product) {
            if (productIsSpecial != null && productIsSpecial.isSpecial()) {
                countIsSpec++;
            }
        }
        return countIsSpec;
    }
}

