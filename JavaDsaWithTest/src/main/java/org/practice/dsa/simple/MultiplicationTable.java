package org.practice.dsa.simple;

public class MultiplicationTable {
    public static void main(String[] args) {
        printMultiplicationTable(5);
    }

    public static void printMultiplicationTable(int number) {
        for (int i = 1; i <=10; i++) {
            System.out.println(number*i);
        }
    }
}
