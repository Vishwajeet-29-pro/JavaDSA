package org.practice.dsa.leet_code.medium.bs;

import java.util.Arrays;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1453383644/

public class SearchStartEndPos {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(searchRange(arr,1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = getInts(nums, target, true);
        if (result[0] == -1) {
            return result;
        }
        result[1] = getInts(nums, target, false);
        return result;
    }

    private static int getInts(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length -1;
        int bound = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) {
                bound = mid;

                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return bound;
    }
}
