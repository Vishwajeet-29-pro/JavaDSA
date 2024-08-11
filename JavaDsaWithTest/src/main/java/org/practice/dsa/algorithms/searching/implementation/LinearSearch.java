package org.practice.dsa.algorithms.searching.implementation;

/*Linear Search implementation*/

public class LinearSearch {
    public int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length < 1) return Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) return i;
        }
        return Integer.MAX_VALUE;
    }

    /* Linear Search implementation returns the target itself if found. */
    public int linearSearchEnhance(int[] arr, int target) {
        if (arr == null || arr.length < 1) throw new RuntimeException("Empty arr passed");

        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        throw new RuntimeException("Target element is not found.");
    }

    public boolean booleanLinearSearch(int[] arr, int target) {
        if (arr == null || arr.length < 1) throw new RuntimeException("Empty arr passed");

        for(int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}
