package org.practice.dsa.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 6, 4, 5};
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[max]) {
                selectionSort(arr, r, c+1, c);
            } else {
                selectionSort(arr, r, c+1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r -1];
            arr[r-1] = temp;
        }
        selectionSort(arr, r-1, 0, 0);
    }
}
