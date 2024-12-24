package org.practice.dsa.recursion.easy;

public class CountOfZeros {
    public int countZero(int n) {
        return helper(n, 0);
    }

    private int helper(int n, int count) {
        if (n == 0) {
            return count;
        }
        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n/10, count);
    }
}
