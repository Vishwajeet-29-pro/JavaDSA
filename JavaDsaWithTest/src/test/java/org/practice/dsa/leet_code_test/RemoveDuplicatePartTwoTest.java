package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionRemoveDuplicatePartTwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatePartTwoTest {

    @Test
    public void testRemoveDuplicates() {
        int[] nums = {1,1,1,2,2,3};
        int expectedK = 5;

        int result = QuestionRemoveDuplicatePartTwo.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }

    @Test
    public void testRemoveDuplicates_() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int expectedK = 7;

        int result = QuestionRemoveDuplicatePartTwo.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }
}
