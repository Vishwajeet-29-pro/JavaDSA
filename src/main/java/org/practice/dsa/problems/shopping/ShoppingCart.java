package org.practice.dsa.problems.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void removeItemFromCart(Item item) {
        items.remove(item);
    }

    public void applyDiscount(double discount) {
        for (Item item : items) {
            double discountPrice = item.getPrice() * (1- discount);
            item.setPrice(discountPrice);
        }
    }

    public boolean checkout(PaymentProcessor processor) {
        double totalPrice = getTotalPrice();
        boolean paymentSuccessful = processor.processPayment(totalPrice);
        if (paymentSuccessful) {
            items.clear();
        }
        return paymentSuccessful;
    }
}
