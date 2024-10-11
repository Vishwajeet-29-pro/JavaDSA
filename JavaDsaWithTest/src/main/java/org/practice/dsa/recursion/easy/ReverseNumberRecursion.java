package org.practice.dsa.recursion.easy;

public class ReverseNumberRecursion {

    int sum = 0;

    public void reverseNumber(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;

        sum = sum * 10 + rem;
        reverseNumber(n/10);
    }
}
