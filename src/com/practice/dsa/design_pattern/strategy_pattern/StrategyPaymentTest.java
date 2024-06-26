package com.practice.dsa.design_pattern.strategy_pattern;

public class StrategyPaymentTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // credit card payment
        cart.setPaymentStrategy(new CreditCardPayment(
                "2022102032043","John Doe","228","12/25"));
        cart.checkout(20000);

        // paypal payment
        cart.setPaymentStrategy(new PayPalPayment("johndoe22@example.com","doeJohn@23"));
        cart.checkout(24320);

        // Bitcoin payment
        cart.setPaymentStrategy(new BitCoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        cart.checkout(34323);
    }
}
