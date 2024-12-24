package org.practice.dsa.solidprinciple.ocp;

public class Circle implements ShapeInterface {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
