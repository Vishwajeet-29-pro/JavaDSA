package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {

    @Test
    public void testRotateArray() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] expected = {5,6,7,1,2,3,4};

        QuestionRotateArray.rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRotateArray_() {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        int[] expected = {3,99,-1,-100};

        QuestionRotateArray.rotate(nums,k);
        assertArrayEquals(expected, nums);
    }
}
