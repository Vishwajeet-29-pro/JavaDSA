package org.practice.dsa.algorithms.searching.implementation;

public class LinearSearch {
    public int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length < 1) return Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) return i;
        }
        return Integer.MAX_VALUE;
    }

    /*Linear Search implementation*/
}
