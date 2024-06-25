package com.practice.dsa.design_pattern.observer_pattern;

/*
* This implementation of the Observer pattern allows multiple investors to be notified whenever there is a change in the
* stock price, without tightly coupling the stock to the investors. The stock (subject) maintains a list of investors
* (observers) and notifies them whenever its state changes.
* */

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
