package org.practice.dsa.solidprinciple.lsp;

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}
