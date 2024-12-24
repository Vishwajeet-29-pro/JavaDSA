package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InsertionSortTest {

    private final InsertionSort sort = new InsertionSort();

    @Test
    public void testInsertionSortForEmptyArray() {
        int[] arr = {};
        Exception exception = assertThrows(RuntimeException.class,() ->
                sort.insertionSort(arr)
        );

        assertEquals("Empty array passed", exception.getMessage());
    }
    @Test
    public void testInsertionSort() {
        int[] arr = {4,2,8,3,1};
        sort.insertionSort(arr);
        assertEquals(2, arr[1], "second element in the array after sorting should be 2");
        assertEquals(8, arr[arr.length-1],"Last element should be greater than all");
    }
}
