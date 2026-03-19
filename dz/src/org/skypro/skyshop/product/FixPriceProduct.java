package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static int FIX_PRICE = 100;
    public FixPriceProduct(String productName, int fixPrice) {
        super(productName);
        this.FIX_PRICE = fixPrice;
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }
}
