package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionRemoveElementFromSortedArrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementsFromSortedArrayTest {

    @Test
    public void testRemoveElements() {
        int[] arr = {1,1,2};
        int expectedOutput = 2;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(arr);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testRemoveElementsFromSortedArray() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int expectedK = 5;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }
}
