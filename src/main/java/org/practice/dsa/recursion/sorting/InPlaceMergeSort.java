package org.practice.dsa.recursion.sorting;

import java.util.Arrays;

/**
 * Time Complexity of InPlace Merge Sort is O(n log n)
 * Space Complexity of InPlace Merge Sort is O(1).
 */
public class InPlaceMergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 0, 8};
        inPlaceMergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void inPlaceMergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (s + e) /2;
        inPlaceMergeSort(arr, s, mid);
        inPlaceMergeSort(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e-s];

        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
                k++;
            }
        while(i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
