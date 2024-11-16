package org.practice.dsa.leet_code.easy.sorting;

// https://leetcode.com/problems/maximum-product-of-three-numbers/description/
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        sorting(nums);
        int product1 = 1;
        for (int i = nums.length-1; i >= nums.length-3; i--) {
            product1 = product1 * nums[i];
        }
        int n = nums.length;
        int product2 = nums[0] * nums[1] * nums[n-1];
        return Math.max(product1, product2);
    }

    public static void sorting(int[] nums) {
        boolean isSwapped;

        for (int i = 0; i < nums.length-1; i++) {
            isSwapped = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
