package com.practice.dsa.oops.shape;

public abstract class Shape {
    private String color;
    private double area;

    public Shape(String color){
        this.color = color;
    }
    abstract void calculateArea();
    void displayDetails(){
        System.out.println("The color for shape is : "+color);
        System.out.println("The area of the shape is: "+area);
    }
}
