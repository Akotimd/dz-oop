package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
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
        System.out.printf("Итого: %.2f %n", getTotalCost());
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

    public List<Product> removeProduct(String productName) {
        ArrayList<Product> removesProduct = new ArrayList<>();
        Iterator<Product> iterator = product.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (productName.equals(currentProduct.getProductName())) {
                removesProduct.add(currentProduct);
                iterator.remove();
                System.out.println("Удалён продукт: " + currentProduct);
            }
        }
//        if (removesProduct.isEmpty()) { System.out.println("Список пуст"); }
        return removesProduct;
    }

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

