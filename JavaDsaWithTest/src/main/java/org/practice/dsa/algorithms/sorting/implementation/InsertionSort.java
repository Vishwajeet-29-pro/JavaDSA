package org.practice.dsa.algorithms.sorting.implementation;

/*Insertion Sort algorithm implementation*/
public class InsertionSort {

    public void insertionSort(int[] arr) {
        if (arr.length == 0) throw new RuntimeException("Empty array passed");

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
