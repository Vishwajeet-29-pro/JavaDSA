package org.practice.dsa.solidprinciple.ocp;

public class Main {
    public static void main(String[] args) {
        ShapeInterface rectangle = new Rectangle(10, 20);
        ShapeInterface circle = new Circle(20);
        ShapeInterface triangle = new Triangle(20, 5);

        System.out.println("Area of Rectangle: "+rectangle.calculateArea());
        System.out.println("Area of Circle: "+circle.calculateArea());
        System.out.println("Area of Triangle: "+triangle.calculateArea());
    }
}
