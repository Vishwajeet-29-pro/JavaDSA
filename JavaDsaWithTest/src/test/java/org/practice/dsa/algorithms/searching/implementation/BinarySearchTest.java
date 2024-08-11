package org.practice.dsa.algorithms.searching.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTest {

    private BinarySearch bs = new BinarySearch();

    @Test
    public void testBinarySearch() {
        int[] arr = {10,20,30,40,50};
        int target = 50;
        assertEquals(4, bs.binarySearch(arr, target));
        assertEquals(0, bs.binarySearch(arr, 10));
    }

    @Test
    public void testBinarySearchForEmptyArray() {
        int [] arr = {};
        int target = 0;
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bs.binarySearch(arr, target);
        });

        assertEquals("Empty arr passed.", exception.getMessage());
    }
}
