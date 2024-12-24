package org.practice.dsa.design_pattern.observer_pattern;

public class InvestorObserver implements Observer{

    private String name;
    private Stock stock;

    public InvestorObserver(String name, Stock stock) {
        this.name = name;
        this.stock = stock;
    }

    @Override
    public void update() {
        System.out.println("Notification to " + name + ": Stock price changed to " + stock.getPrice());
    }
}
