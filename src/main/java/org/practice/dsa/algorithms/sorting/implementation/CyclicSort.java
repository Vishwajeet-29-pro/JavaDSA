package org.practice.dsa.algorithms.sorting.implementation;

public class CyclicSort {
    /*Cyclic sort implementation*/
    public void cyclicSort(int[] arr) {
        if (arr == null || arr.length < 1) throw new RuntimeException("Empty array passed.");

        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
