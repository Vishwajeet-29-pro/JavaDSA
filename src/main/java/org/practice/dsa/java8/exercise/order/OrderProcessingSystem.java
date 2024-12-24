package org.practice.dsa.java8.exercise.order;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderProcessingSystem {

    // Find the total price of all completed orders.
    public double findTotalPriceOfAllCompleteOrder(List<Order> orders) {
        return orders.stream()
                .filter(order -> "COMPLETED".equalsIgnoreCase(order.getStatus()))
                .flatMap(product -> product.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Find the most expensive product across all orders.
    public Optional<Product> findMostExpensiveProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .max(Comparator.comparingDouble(Product::getPrice));
    }

    // Create a list of all unique products bought across all orders
    public List<Product> findUniqueProductsAcrossAllOrder(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
    }

    // Get the average price of all products across completed orders
    public double findAveragePriceOfProducts(List<Order> orders) {
        return orders.stream()
                .filter(order -> "COMPLETED".equalsIgnoreCase(order.getStatus()))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }
}
