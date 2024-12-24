package org.practice.dsa.recursion.easy;

public class ProductOfDigits {
    public int productNumbers(int n) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * productNumbers(n / 10);
    }
}
