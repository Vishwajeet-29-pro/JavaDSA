package org.practice.dsa.oops.abstraction.shape;

public abstract class Shape implements Drawable{
    protected String color;
    protected double area;

    public Shape(String color){
        this.color = color;
    }
    abstract void calculateArea();
    void displayDetails(){
        System.out.println("The color for shape is : "+color);
        System.out.println("The area of the shape is: "+area);
    }
}
