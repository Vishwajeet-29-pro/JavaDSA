package org.practice.dsa.java8.exercise.customer;

import java.util.List;

public class Order {
    int orderId;
    List<Item> items;

    public Order(int orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
