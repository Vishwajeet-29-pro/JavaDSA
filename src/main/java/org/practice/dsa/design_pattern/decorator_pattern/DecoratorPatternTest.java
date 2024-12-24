package org.practice.dsa.design_pattern.decorator_pattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription()+" $"+ coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription()+" $"+coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription()+" $"+coffee.getCost());

        coffee = new WhipDecorator(coffee);
        System.out.println(coffee.getDescription()+" $"+coffee.getCost());
    }
}
