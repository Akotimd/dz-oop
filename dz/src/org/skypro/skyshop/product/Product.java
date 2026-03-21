package org.skypro.skyshop.product;

public abstract class  Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }
}


