package com.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getProductId() == id);
    }

    public Product searchProduct(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
    public boolean updateProduct(int id, String name, String category,
                                 double price, int quantity, String supplier) {

        Product product = searchProduct(id);

        if (product != null) {
            // remove old product
            deleteProduct(id);

            // create updated product
            Product updated = new Product(id, name, category, price, quantity, supplier);

            // add updated product
            addProduct(updated);

            return true;
        }

        return false;
    }
}