package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
