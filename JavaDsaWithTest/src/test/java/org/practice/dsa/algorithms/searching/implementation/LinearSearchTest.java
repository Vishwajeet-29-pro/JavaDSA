package org.practice.dsa.algorithms.searching.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTest {
    private final LinearSearch ls = new LinearSearch();

    @Test
    public void testLinearSearchImpl() {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int target = 60;
        assertEquals(5, ls.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearchForEmptyArr() {
        int[] arr = {};
        assertEquals(Integer.MAX_VALUE, ls.linearSearch(arr, 0));
    }
}
