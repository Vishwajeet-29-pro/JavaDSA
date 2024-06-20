package com.practice.dsa.oops.shape;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle ");
    }

    @Override
    void calculateArea() {
        area = Math.PI * radius * radius;
    }
}
