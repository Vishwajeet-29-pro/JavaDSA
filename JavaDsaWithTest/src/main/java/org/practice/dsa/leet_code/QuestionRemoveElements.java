package org.practice.dsa.leet_code;

import java.util.Arrays;

public class QuestionRemoveElements {

    public static int removeElements(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
