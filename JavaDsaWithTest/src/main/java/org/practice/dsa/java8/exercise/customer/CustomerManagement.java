package org.practice.dsa.java8.exercise.customer;

import java.util.Comparator;
import java.util.Optional;

public class CustomerManagement {

    // Get the total value of all orders for a given customer.
    public double getAllOrderForCustomer(Customer customer) {
        return customer.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(Item::getPrice)
                .sum();
    }

    // Find the most expensive item across all orders for a customer.
    public Optional<Item> findExpensiveItem(Customer customer) {
        return customer.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                .max(Comparator.comparingDouble(Item::getPrice));

    }

}
