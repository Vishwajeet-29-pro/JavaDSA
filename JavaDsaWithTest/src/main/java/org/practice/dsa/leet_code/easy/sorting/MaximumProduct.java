package org.practice.dsa.leet_code.easy.sorting;

import java.util.Arrays;
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaximumProduct {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }
}
