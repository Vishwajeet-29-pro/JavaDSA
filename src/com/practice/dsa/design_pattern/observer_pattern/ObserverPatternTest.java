package com.practice.dsa.design_pattern.observer_pattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        Stock appleStock = new Stock();

        InvestorObserver observer1 = new InvestorObserver("Investor 1", appleStock);
        InvestorObserver observer2 = new InvestorObserver("Investor 2", appleStock);

        appleStock.attach(observer1);
        appleStock.attach(observer2);

        System.out.println("Setting Stock price to 100.00");
        appleStock.setPrice(100);

        appleStock.detach(observer1);
        System.out.println("Setting Stock price to 200.00");
        appleStock.setPrice(200);
    }
}
