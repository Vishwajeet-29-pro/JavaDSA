package org.practice.dsa.recursion.easy;

public class SumUpToN {

    public int sumUpToN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumUpToN(n -1);
    }
}
