package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortTest {

    private final SelectionSort sort = new SelectionSort();

    @Test
    public void testSelectionSort() {
        int[] arr = {2,6,3,0,8,7};
        sort.selectionSort(arr);
        assertEquals(2, arr[1],"Second element after sorting should be 2");
        assertEquals(8,arr[arr.length-1],"Last element should be greater than all");
    }
}
