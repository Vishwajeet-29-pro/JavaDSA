package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionRemoveElementFromSortedArrays;
import org.practice.dsa.leet_code.QuestionRemoveElements;

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

    @Test
    public void testNoDuplicates() {
        int[] nums = {1,2,3,4,5};
        int expectedK = 5;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }

    @Test
    public void testAllSame() {
        int[] nums = {1,1,1,1};
        int expectedInt = 1;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedInt, result);
    }

    @Test
    public void testMixDuplicate() {
        int[] nums = {1,1,2,2,3,3,4,4};
        int expectedK = 4;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {7};
        int expectedK = 1;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int expectedK = 0;

        int result = QuestionRemoveElementFromSortedArrays.removeDuplicates(nums);
        assertEquals(expectedK, result);
    }
}
