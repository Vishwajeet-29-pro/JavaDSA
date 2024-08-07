package org.practice.dsa.problems.shopping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void testAddItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Apple",20);
        cart.addItem(item);

        assertEquals(1, cart.getItemCount());
        assertEquals(20, cart.getTotalPrice());
    }

    @Test
    public void testRemoveItemFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Banana",30.5);
        cart.addItem(item);
        cart.removeItemFromCart(item);

        assertEquals(0,cart.getItemCount());
        assertEquals(0.0,cart.getTotalPrice());
    }

    @Test
    public void testApplyDiscount() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Apple",0.99);
        cart.addItem(item);
        // apply discount
        cart.applyDiscount(0.10); // applying 10% discount.

        assertEquals(0.89, cart.getTotalPrice(),0.01);
    }

    @Test
    public void testCheckout() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("Apple",20);
        Item item2 = new Item("Banana", 30);
        cart.addItem(item1);
        cart.addItem(item2);

        PaymentProcessor processor = new PaymentProcessor();
        boolean paymentResult = cart.checkout(processor);

        assertTrue(paymentResult);
        assertEquals(0, cart.getTotalPrice());
    }
}
