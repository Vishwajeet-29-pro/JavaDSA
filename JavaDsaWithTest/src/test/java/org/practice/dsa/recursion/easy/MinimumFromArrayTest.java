package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumFromArrayTest {

    private final MinAndMaxFromArray m = new MinAndMaxFromArray();

    @Test
    public void testMinimumFromArray() {
        int[] arr = {2, 0, -5, 5, -8, 19, -16};

        assertEquals(-16, m.findMin(arr, arr.length));
        assertEquals(19, m.findMax(arr, arr.length));
    }
}