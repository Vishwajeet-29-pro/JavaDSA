package org.practice.dsa.java8.exercise.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerManagementTest {

    private CustomerManagement customerManagement;
    private Customer customer;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setup() {
        Item item1 = new Item("Monitor",200.0);
        Item item2 = new Item("CPU",200.0);
        Item item3 = new Item("Mouse",200.0);
        Item item4 = new Item("Keyboard",200.0);

        order1 = new Order(101, List.of(item1, item2));
        order2 = new Order(102, List.of(item3, item4));

        customer = new Customer("Vishwajeet",List.of(order1, order2));
        customerManagement = new CustomerManagement();
    }

    @Test
    public void testTotalValueOfOrder() {
        double expected = 800.0;
        double actual = customerManagement.getAllOrderForCustomer(customer);
        assertEquals(expected, actual);
    }
}
