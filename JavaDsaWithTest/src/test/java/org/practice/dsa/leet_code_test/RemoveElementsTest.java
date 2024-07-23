package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionRemoveElements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementsTest {

    @Test
    public void testRemoveElements() {
        int[] arr = {3,2,2,3};
        int val = 3;
        int expectedK = 2;
        int[] expected = {2,2};

        int result = QuestionRemoveElements.removeElements(arr, val);
        assertEquals(expectedK, result);

    }
}
