package org.practice.dsa.leet_code;

public class QuestionRemoveElementFromSortedArrays {

    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
    unique element appears only once. The relative order of the elements should be kept the same. Then return the
    number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were
    present in nums initially. The remaining elements of nums are not important as well as the size of nums.

    Return k.
    */

    public static int removeDuplicates(int[] nums) {
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        System.out.println("k:-> "+k+" k+1:-> "+(k+1));
        return k+1;
    }

}
