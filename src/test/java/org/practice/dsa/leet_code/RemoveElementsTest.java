package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementsTest {

    @Test
    public void testRemoveElements() {
        int[] arr = {3,2,2,3};
        int val = 3;
        int expectedK = 2;

        int result = QuestionRemoveElements.removeElements(arr, val);
        assertEquals(expectedK, result);
    }

    @Test
    public void testRemoveElementsNoVal() {
        int[] arr = {1,2,4,5};
        int val = 3;
        int expectedK = 4;

        int result = QuestionRemoveElements.removeElements(arr, val);
        assertEquals(expectedK, result);
    }

    @Test
    public void testRemoveElementsAll() {
        int[] arr = {2,2,2};
        int val = 2;
        int expectedK = 0;

        int result = QuestionRemoveElements.removeElements(arr, val);
        assertEquals(expectedK, result);
    }

    @Test
    public void testRemoveElementsEmptyArray() {
        int[] arr = {};
        int val = 3;
        int expectedK = 0;

        int result = QuestionRemoveElements.removeElements(arr, val);
        assertEquals(expectedK, result);
    }
}
