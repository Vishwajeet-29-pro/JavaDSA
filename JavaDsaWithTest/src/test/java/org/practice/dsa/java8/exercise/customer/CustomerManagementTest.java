package org.practice.dsa.java8.exercise.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerManagementTest {

    private CustomerManagement customerManagement;
    private Customer customer;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setup() {
        Item item1 = new Item("Monitor",700.0);
        Item item2 = new Item("CPU",800.0);
        Item item3 = new Item("Mouse",300.0);
        Item item4 = new Item("Keyboard",400.0);

        order1 = new Order(101, List.of(item1, item2));
        order2 = new Order(102, List.of(item3, item4));

        customer = new Customer("Vishwajeet",List.of(order1, order2));
        customerManagement = new CustomerManagement();
    }

    @Test
    public void testTotalValueOfOrder() {
        double expected = 2200.0;
        double actual = customerManagement.getAllOrderForCustomer(customer);
        assertEquals(expected, actual);
    }

    // Find the most expensive item across all orders for a customer.
    @Test
    public void testFindExpensiveItem() {
        Optional<Item> expected = Optional.of(order1.getItems().get(1));
        Optional<Item> actual = customerManagement.findExpensiveItem(customer);
        assertEquals(expected, actual);
    }
}
