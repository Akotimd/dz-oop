package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] product;

    public ProductBasket() {
        this.product = new Product[5];
    }

    public void addProduct(Product newProduct) {
        boolean added = false;
        for (int i = 0; i < this.product.length; i++) {
            if (this.product[i] == null) {
                this.product[i] = newProduct;
                added = true;
                break;
            }
        } if (!added) {
            System.out.println("Product not added");
        }
    }

    public void printBasket() {
        boolean isEmpty = true;
        for (Product productBasket : product) {
            if (productBasket != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            for (Product productBasket : product) {
                if (productBasket != null) {
                    System.out.println(productBasket);
                }
            }
        }
    }
    public int costBasket() {
        int price = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                price += product[i].getPrice();
            }
        }
        return price;
    }
    public boolean nameProduct(String productName) {
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
        for (int i = 0; i < product.length; i++) {
            product[i] = null;
        }
    }
}

