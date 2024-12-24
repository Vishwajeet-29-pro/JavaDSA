package org.practice.dsa.solidprinciple.lsp;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        Shape square = new Square(10);

        System.out.println("Area of Rectangle: "+ rectangle.calculateArea());
        System.out.println("Area of Square: "+square.calculateArea());
    }
}
