package org.practice.dsa.design_pattern.strategy_pattern;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderNumber = cardHolderNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" using CreditCard");
    }
}
