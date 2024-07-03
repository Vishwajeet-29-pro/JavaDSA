package org.practice.dsa.oops.abstraction.shape;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        area = 0.5 * base * height;
        area = Double.parseDouble(String.format("%.2f",area));
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}
