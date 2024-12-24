package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayTest {

    private final SortedArray array = new SortedArray();

    @Test
    public void test_when_array_is_sorted_should_return_true() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        assertTrue(array.isArraySorted(arr, 0));
    }

    @Test
    public void test_when_array_is_not_sorted_should_return_false() {
        int[] arr = {1,23,2, 4, 6, 3};
        assertFalse(array.isArraySorted(arr, 0));
    }
}