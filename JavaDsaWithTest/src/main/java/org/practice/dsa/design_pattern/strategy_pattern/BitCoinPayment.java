package org.practice.dsa.design_pattern.strategy_pattern;

public class BitCoinPayment implements PaymentStrategy {
    private String bitCoinAddress;

    public BitCoinPayment(String bitCoinAddress){
        this.bitCoinAddress = bitCoinAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" using BitCoins !!");
    }
}
