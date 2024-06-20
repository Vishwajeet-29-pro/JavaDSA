package com.practice.dsa.oops.shape;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }

    @Override
    void calculateArea() {
        area = width * height;
        area = Double.parseDouble(String.format("%.2f",area));
    }
}
