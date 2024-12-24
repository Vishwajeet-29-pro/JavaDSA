package org.practice.dsa.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuestion1 {
    private final Question1 question1 = new Question1();

    @Test
    public void testSecondLargest() {
        int[] arr = new int[] {2,3,5,6,3,7};
        assertEquals(6, question1.secondLargest(arr));
    }

    @Test
    public void testSecondLargestWithAllSame() {
        int[] arr = new int[] {1,1,1,1};
        assertEquals(Integer.MIN_VALUE, question1.secondLargest(arr));
    }

    @Test
    public void testSecondLargestWithSingleValue() {
        int[] arr = new int[] {1};
        assertEquals(Integer.MIN_VALUE, question1.secondLargest(arr));
    }

    @Test
    public void testAnotherSecondLargestMethod() {
        int[] arr = new int[] {2,3,5,1,7};
        assertEquals(5, question1.anotherSecondLargest(arr));
    }

    @Test
    public void testSecondLargestWithBubbleSort() {
        int[] arr = {2,3,9,4,7};
        assertEquals(7, question1.secondLargestWithBubbleSort(arr));
    }
}
