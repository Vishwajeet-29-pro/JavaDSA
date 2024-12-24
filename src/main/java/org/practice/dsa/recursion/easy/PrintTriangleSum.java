package org.practice.dsa.recursion.easy;

import java.util.Arrays;

public class PrintTriangleSum {

    public static void main(String[] args) {
        printTriangle(new int[] {1,2,3,4,5});
    }
    public static void printTriangle(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length-1; i++) {
            int sum = arr[i] + arr[i+1];
            temp[i] = sum;
        }

        printTriangle(temp);

        System.out.println(Arrays.toString(arr));
    }
}
