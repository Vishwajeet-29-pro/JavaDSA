package org.practice.dsa.recursion.easy;

public class MinAndMaxFromArray {

    public int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.min(arr[n-1], findMin(arr, n -1));
    }

    public int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n-1], findMax(arr, n-1));
    }
}
