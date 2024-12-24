package org.practice.dsa.recursion.sorting;

import java.util.Arrays;

/**
 * Time Complexity of Quick Sort:
 * For Best Case: O(n log n)
 *      The pivot divides the array into two nearly equal halves at each step.
 *      Number of levels = log n, and at each level, the partitioning takes O(n)
 * For Worst Case: O(n^2) (n square)
 *      Occurs when the pivot is the smallest or largest element,
 *      leading to highly unbalanced partitions (e.g., sorted or reverse-sorted input).

 * Space Complexity:
 * Best and Average Case: O(log n)
 *      Recursive calls are proportional to the height of the recursion tree, which is log n
 *      for balanced partitions
 * Worst case: O(n)
 *      In the worst case (highly unbalanced partitions), the recursion tree depth is n.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,2,6,3,1,5};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
