package org.practice.dsa.recursion.array;

public class SortedArray {

    public boolean isArraySorted(int[] arr, int index) {
        if (arr[index] == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && isArraySorted(arr, index + 1);
    }
}
