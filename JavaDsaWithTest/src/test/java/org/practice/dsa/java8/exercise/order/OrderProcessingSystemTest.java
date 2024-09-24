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

    @BeforeEach
    public void setup() {
        Product p1 = new Product("CPU", 25000);
        Product p2 = new Product("Monitor", 20000);
        Product p3 = new Product("Mouse", 1000);
        Product p4 = new Product("Keyboard", 1400);

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
        Optional<Product> expected = Optional.of(new Product("CPU", 25000));
        Optional<Product> actual = orderProcessing.findMostExpensiveProduct(orders);

        assertTrue(actual.isPresent());
        assertEquals(expected.get().getName(), actual.get().getName());
        assertEquals(expected.get().getPrice(), actual.get().getPrice());
    }
}