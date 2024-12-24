package org.practice.dsa.leet_code.medium.bs;

// https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/
public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid+1]) {
                start = mid+2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
