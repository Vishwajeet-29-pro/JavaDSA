package org.practice.dsa.design_pattern.decorator_pattern;

public class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() +", whip";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.7;
    }
}
