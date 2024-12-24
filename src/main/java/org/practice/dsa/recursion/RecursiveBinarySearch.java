package org.practice.dsa.recursion;

public class RecursiveBinarySearch {

    public int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target > arr[mid]) {
            return binarySearch(arr, target, mid+1, end);
        }
        return binarySearch(arr, target, start, mid-1);
    }
}
