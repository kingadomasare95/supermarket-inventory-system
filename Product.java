package com.supermarket.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private String supplier;

    public Product(int productId, String productName, String category,
                   double price, int quantity, String supplier) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getTotalValue() {
        return price * quantity;
    }
}