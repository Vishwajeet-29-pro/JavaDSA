package com.practice.dsa.design_pattern.strategy_pattern;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay() {
        System.out.println("Payment from PayPal !!");
    }
}
