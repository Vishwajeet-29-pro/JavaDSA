package org.practice.dsa.solidprinciple.lsp;

/*
* Problem Statement
* Consider a scenario where you have a Rectangle class and a Square class that inherits from Rectangle. Since a square
* is a specific type of rectangle (where all sides are equal), it might seem logical to make Square inherit from Rectangle.
* */


public class OldImplementation {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.calculateArea());  // Output: 50

        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10);
        System.out.println("Square area: " + square.calculateArea());  // Output: 100 (incorrect for a rectangle)
    }

    private static class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int calculateArea() {
            return width * height;
        }
    }

    private static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;  // Ensuring all sides are equal
        }

        @Override
        public void setHeight(int height) {
            this.width = height;
            this.height = height;  // Ensuring all sides are equal
        }
    }
}
/*
* While this design might seem correct, it violates the Liskov Substitution Principle. The Square class overrides the
* behavior of Rectangle by modifying both width and height whenever either one is set. If we substitute a Square object
* where a Rectangle is expected, it could produce incorrect results.
* */
