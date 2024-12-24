package org.practice.dsa.algorithms.searching.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testLinearSearchNoTargetFound() {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int target = 55;
        assertEquals(Integer.MAX_VALUE, ls.linearSearch(arr, target));
    }

    @Test
    public void testLinearSearchEnhanceImplForEmptyArray() {
        int[]  arr = {};
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ls.linearSearchEnhance(arr, 0);
        });
        assertEquals("Empty arr passed", exception.getMessage());
    }

    @Test
    public void testLinearSearchEnhanceImpl() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        assertEquals(50, ls.linearSearchEnhance(arr, target));
    }

    @Test
    public void testBooleanOutputOfLinearSearchImpl() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        assertTrue(ls.booleanLinearSearch(arr, target), "If element found should return true");
        int noMatch = 55;
        assertFalse(ls.booleanLinearSearch(arr, noMatch), "If element not found should return false");
    }
}
