package org.practice.dsa.recursion.pattern;

public class printTriangle {
    public static void main(String[] args) {
        triangle(4, 0);
        System.out.println();
        printTriangle2(4, 0);
    }
    public static void triangle(int r, int c) {
        if (r == 0){
            return;
        }
        if (c < r) {
            System.out.print("*");
            triangle(r, c+1);
        } else {
            System.out.println();
            triangle(r-1, 0);
        }
    }

    public static void printTriangle2(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            printTriangle2(r, c+1);
            System.out.print("*");
        } else {
            printTriangle2(r-1, 0);
            System.out.println();
        }
    }
}
