package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CyclicSortTest {
    private final CyclicSort sort = new CyclicSort();

    @Test
    public void testCyclicSortForEmptyArray() {
        int[] arr = {};
        Exception exception = assertThrows(RuntimeException.class, () -> {
           sort.cyclicSort(arr);
        });

        assertEquals("Empty array passed.", exception.getMessage());
    }

    @Test
    public void testCyclicSort() {
        int[] arr = {5, 4, 3, 2, 1};
        sort.cyclicSort(arr);
        assertEquals(5, arr[4], "After sorting the 4th element of array should be 5");
    }

    @Test
    public void testArrayEqualsUsingCyclicSort() {
        int[] arr = {3, 2, 5, 1, 4};
        int[] expected = {1, 2, 3, 4, 5};

        sort.cyclicSort(arr);

        assertArrayEquals(expected, arr);
    }
}
