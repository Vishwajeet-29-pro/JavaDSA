package org.practice.dsa.leet_code;

import java.util.Arrays;

public class QuestionMajorityElements {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
