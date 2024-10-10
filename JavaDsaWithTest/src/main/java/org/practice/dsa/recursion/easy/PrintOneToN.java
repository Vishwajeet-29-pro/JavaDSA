package org.practice.dsa.recursion.easy;

public class PrintOneToN {

    public static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print1ToN(n-1);
    }

    public static void main(String[] args) {
        print1ToN(5);
    }
}
