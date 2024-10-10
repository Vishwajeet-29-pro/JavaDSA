package org.practice.dsa.recursion.easy;

public class PrintOneToN {

    public void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print1ToN(n-1);
    }
}
