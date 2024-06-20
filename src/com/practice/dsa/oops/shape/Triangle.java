package com.practice.dsa.oops.shape;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    void calculateArea() {
        area = 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}
