package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be blank");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerms() {
        return productName;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }
}


