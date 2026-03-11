package org.skypro.skyshop.product;

public class Product {
    private final String productName;
    private final int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return productName + ": " + price;
    }
}


