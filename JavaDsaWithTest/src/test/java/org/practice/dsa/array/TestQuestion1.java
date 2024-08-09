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
}
