package org.practice.dsa.java8.exercise.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingSystemTest {

    private final OrderProcessingSystem orderProcessing = new OrderProcessingSystem();
    private List<Order> orders;
    Product p1;
    Product p2;
    Product p3;
    Product p4;

    @BeforeEach
    public void setup() {
        p1 = new Product("CPU", 25000);
        p2 = new Product("Monitor", 20000);
        p3 = new Product("Mouse", 1000);
        p4 = new Product("Keyboard", 1400);

        Order o1 = new Order("COMPLETED", List.of(p1, p2, p3));
        Order o2 = new Order("PENDING", List.of(p1, p2, p4));
        Order o3 = new Order("COMPLETED", List.of(p1, p2, p3, p4));
        Order o4 = new Order("CANCELED", List.of(p3, p4));

        orders = List.of(o1, o2, o3, o4);
    }

    // Find the total price of all completed orders.
    @Test
    public void testFindTotalPriceOfAllCompleteOrders() {
        double expected = 93400;
        double actual = orderProcessing.findTotalPriceOfAllCompleteOrder(orders);
        assertEquals(expected, actual);
    }

    // Find the most expensive product across all orders.
    @Test
    public void testFindMostExpensiveProduct() {
        Optional<Product> expected = Optional.of(p1);
        Optional<Product> actual = orderProcessing.findMostExpensiveProduct(orders);

        assertTrue(actual.isPresent());
        assertEquals(expected.get().getName(), actual.get().getName());
        assertEquals(expected.get().getPrice(), actual.get().getPrice());
    }

    // Create a list of all unique products bought across all orders
    @Test
    public void testFindUniqueProductsFromAllOrders() {
        List<Product> expected = List.of(p1, p2, p3, p4);
        List<Product> actual = orderProcessing.findUniqueProductsAcrossAllOrder(orders);
        assertEquals(expected, actual);
        actual.stream().map(Product::getName).forEach(System.out::println);
    }

    // Get the average price of all products across completed orders
    @Test
    public void testAveragePriceOfProductThatCompletedOrders() {
        double expected = 13342.857142857143;
        double actual = orderProcessing.findAveragePriceOfProducts(orders);

        assertEquals(expected, actual);
    }
}