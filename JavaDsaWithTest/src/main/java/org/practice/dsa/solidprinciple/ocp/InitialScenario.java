package org.practice.dsa.solidprinciple.ocp;

public class InitialScenario {

}
// Initial Implementation of Scenario.
class Shape {
    public enum ShapeType {
        CIRCLE, RECTANGLE
    }

    private ShapeType type;
    private double radius;
    private double length;
    private double width;

    // Constructor for Circle
    public Shape(double radius) {
        this.type = ShapeType.CIRCLE;
        this.radius = radius;
    }

    // Constructor for Rectangle
    public Shape(double length, double width) {
        this.type = ShapeType.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        switch (type) {
            case CIRCLE:
                return Math.PI * radius * radius;
            case RECTANGLE:
                return length * width;
            default:
                throw new UnsupportedOperationException("Shape not supported");
        }
    }
}
