package org.practice.dsa.leet_code.easy.sorting;

import java.util.Arrays;

public class SortSquares {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i]*arr[i];
        }
        System.out.println("Squares before sorting:"+Arrays.toString(result));
        Arrays.sort(result);
        return result;
    }
}
