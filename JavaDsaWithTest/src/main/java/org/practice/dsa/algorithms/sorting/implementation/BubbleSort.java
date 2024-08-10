package org.practice.dsa.algorithms.sorting.implementation;

// Bubble sort algorithm implementation.
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) throw  new RuntimeException("Empty array passed");
        boolean swapped;

        for (int i =0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
