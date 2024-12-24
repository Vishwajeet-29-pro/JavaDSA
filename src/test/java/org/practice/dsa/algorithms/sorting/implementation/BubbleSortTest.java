package org.practice.dsa.algorithms.sorting.implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    private final BubbleSort sort = new BubbleSort();

    @Test
    public void testBubbleSort() {
        int[] arr = new int[] {10,8,6,4,2,0};
        sort.bubbleSort(arr);
        assertEquals(2, arr[1],"After swap the second number should be 2");
        assertEquals(10, arr[arr.length-1], "After swap the last number should be 10");
    }

    @Test
    public void testBubbleSortWithCorrectAssertionMethod() {
        int[] arr = {10,8,6,4,2,0};
        int[] expected = {0,2,4,6,8,10};
        sort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testIfArrayLengthIsZero() {
        int[] arr = {};
        Exception exception = assertThrows(RuntimeException.class,() -> sort.bubbleSort(arr));
        assertEquals("Empty array passed", exception.getMessage());
    }
}
