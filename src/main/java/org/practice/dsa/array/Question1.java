package org.practice.dsa.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question1 {

    /* Find the Second-Largest Number in an Array*/

    public int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i: arr) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second && i != first) {
                second = i;
            }
        }
        return second == Integer.MIN_VALUE ? Integer.MIN_VALUE : second;
    }

    public int anotherSecondLargest(int[] arr) {
        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        return sortedArray[sortedArray.length-2];
    }

    public int secondLargestWithBubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;
        bubbleSort(arr);
        return arr[arr.length -2];
    }

    private void bubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
