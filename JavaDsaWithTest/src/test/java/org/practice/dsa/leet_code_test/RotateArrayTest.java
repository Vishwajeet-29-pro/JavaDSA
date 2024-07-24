package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionRemoveElements;
import org.practice.dsa.leet_code.QuestionRotateArray;

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
}
