package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void testBubbleSort() {
        int[] arr = new int[] {10,8,6,4,2,0};
        bubbleSort.bubbleSort(arr);
        assertEquals(2, arr[1],"After swap the second number should be 2");
        assertEquals(10, arr[arr.length-1], "After swap the last number should be 10");
    }
}
