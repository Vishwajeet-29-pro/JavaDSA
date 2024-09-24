package org.practice.dsa.java8.exercise.order;

import java.util.List;

public class Order {
    private String status;
    private List<Product> products;

    public Order(String status, List<Product> products) {
        this.status = status;
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }
}
