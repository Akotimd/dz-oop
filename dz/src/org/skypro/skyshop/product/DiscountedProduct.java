package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discountedPrice;

    public DiscountedProduct(String productName, double basePrice, int discountedPrice) {
        super(productName);
        this.basePrice = basePrice;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discountedPrice / 100.0);
    }
}
