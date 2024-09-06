package org.practice.dsa.java8.exercise.customer;

import java.util.List;

public class Customer {
    String name;
    List<Order> orders;

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
