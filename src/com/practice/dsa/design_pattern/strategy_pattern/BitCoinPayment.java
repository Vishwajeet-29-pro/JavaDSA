package com.practice.dsa.design_pattern.strategy_pattern;

public class BitCoinPayment implements PaymentStrategy {
    private String bitCoinAddress;

    public BitCoinPayment(String bitCoinAddress){
        this.bitCoinAddress = bitCoinAddress;
    }

    @Override
    public void pay() {
        System.out.println("Payment from BitCoins !!");
    }
}
