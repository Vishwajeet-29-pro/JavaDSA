package org.practice.dsa.leet_code;

import java.util.Arrays;

public class QuestionRotateArray {
    /*
    * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
    * */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
