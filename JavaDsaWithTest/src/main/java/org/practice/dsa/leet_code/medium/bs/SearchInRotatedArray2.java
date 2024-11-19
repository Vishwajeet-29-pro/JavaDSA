package org.practice.dsa.leet_code.medium.bs;

public class SearchInRotatedArray2 {

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(arr, target));
    }

    public static boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid +1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid+1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
