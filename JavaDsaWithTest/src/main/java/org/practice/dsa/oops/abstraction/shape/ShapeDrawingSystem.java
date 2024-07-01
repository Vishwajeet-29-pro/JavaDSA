package org.practice.dsa.oops.abstraction.shape;

public class ShapeDrawingSystem {
    public static void main(String[] args) {
        Shape circle = new Circle("Red",5);
        Shape rectangle = new Rectangle("Blue",10,14.2);
        Shape triangle = new Triangle("Green",20.23, 2.3);

        System.out.println("Shape Circle: ");
        circle.calculateArea();
        circle.displayDetails();
        System.out.println();

        System.out.println("Shape Rectangle: ");
        rectangle.calculateArea();
        rectangle.displayDetails();
        System.out.println();

        System.out.println("Shape Triangle: ");
        triangle.calculateArea();
        triangle.displayDetails();
        System.out.println();
    }
}
