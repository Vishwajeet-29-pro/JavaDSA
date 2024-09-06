package org.practice.dsa.java8.exercise.customer;

public class CustomerManagement {

    // Get the total value of all orders for a given customer.
    public double getAllOrderForCustomer(Customer customer) {
        return customer.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
