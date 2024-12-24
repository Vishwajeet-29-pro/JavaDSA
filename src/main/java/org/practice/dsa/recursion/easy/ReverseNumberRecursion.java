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

    public int reverseNumberUsingRecursionWithHelperMethod(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return (int) (rem * Math.pow(10, digits - 1) + helper(n/10, digits -1));
    }
}
