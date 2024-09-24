package org.practice.dsa.java8.exercise.order;

import java.util.Comparator;
import java.util.List;

public class OrderProcessingSystem {

    // Find the total price of all completed orders.
    public double findTotalPriceOfAllCompleteOrder(List<Order> orders) {
        return orders.stream()
                .filter(order -> "COMPLETED".equalsIgnoreCase(order.getStatus()))
                .flatMap(product -> product.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
