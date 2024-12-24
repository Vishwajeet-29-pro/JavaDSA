package org.practice.dsa.recursion.array;

public class RotatedBinarySearch {
    public int rotatingBS(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return rotatingBS(arr, target, start, mid - 1);
            } else {
                rotatingBS(arr, target, mid + 1, end);
            }
        }
        if (target >= arr[mid] && target <= arr[end]) {
            return rotatingBS(arr, target, mid + 1, end);
        }
        return rotatingBS(arr, target, start, mid -1);
    }
}
