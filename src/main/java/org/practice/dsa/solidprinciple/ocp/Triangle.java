package org.practice.dsa.solidprinciple.ocp;

public class Triangle implements ShapeInterface {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }


    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
