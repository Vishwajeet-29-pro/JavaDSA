package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatedBinarySearchTest {

    private final RotatedBinarySearch rbSearch = new RotatedBinarySearch();

    @Test
    public void rotateBinarySearch() {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int target = 5;
        int actual = rbSearch.rotatingBS(arr, target, 0, arr.length-1);
        assertEquals(1, actual);
    }
}