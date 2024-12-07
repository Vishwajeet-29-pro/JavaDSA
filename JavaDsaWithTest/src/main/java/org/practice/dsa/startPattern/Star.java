package org.practice.dsa.startPattern;

public class Star {
    public static void main(String[] args) {
        printPattern(3);
    }

    static void printPattern(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
