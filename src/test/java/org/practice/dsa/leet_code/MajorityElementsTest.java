package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementsTest {

    @Test
    public void testMajorityElement() {
        int[] arr = {3,2,3};
        int expected = 3;

        int result = QuestionMajorityElements.majorityElement(arr);
        assertEquals(expected, result);
    }
}
