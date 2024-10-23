package org.practice.dsa.recursion.string;

import java.util.Arrays;

public class reverseCharacters {
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(char[] arr) {
        reverseString(arr, 0, arr.length-1);
    }

    private static void reverseString(char[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        char ch = arr[start];
        arr[start] = arr[end];
        arr[end] = ch;

        reverseString(arr, start + 1, end - 1);
    }
}
