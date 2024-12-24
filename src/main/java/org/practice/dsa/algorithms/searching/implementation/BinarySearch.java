package org.practice.dsa.algorithms.searching.implementation;

/* Binary Search algorithm implementation. */
public class BinarySearch {

    public int binarySearch(int[] arr, int target) {

        if (arr == null || arr.length < 1) throw  new RuntimeException("Empty arr passed.");

        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        return -1;
    }
}
