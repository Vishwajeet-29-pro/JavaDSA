package org.practice.dsa.leet_code;

public class QuestionRemoveDuplicatePartTwo {
    /*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each
    unique element appears at most twice. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result
    be placed in the first part of the array nums. More formally, if there are k elements after removing the
    duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave
    beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.
    */

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                counter++;
            } else if (nums[i] != nums[i-1]) {
                counter = 1;
            }
            if(counter <= 2) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
