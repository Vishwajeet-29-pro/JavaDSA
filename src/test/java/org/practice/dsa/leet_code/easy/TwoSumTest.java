package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    private final QuestionTwoSumArray twoSum = new QuestionTwoSumArray();

    @Test
    public void testTwoSum() {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};

        assertArrayEquals(expected, twoSum.twoSum(input, target));
    }

    @Test
    public void testTwoSum2() {
        int[] input = {2, 3, 4};
        int target = 6;
        int[] expected = {1, 3};

        assertArrayEquals(expected, twoSum.twoSum(input, target));
    }
}
