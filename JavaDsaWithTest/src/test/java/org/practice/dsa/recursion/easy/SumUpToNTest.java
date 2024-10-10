package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumUpToNTest {
    private final SumUpToN sum = new SumUpToN();

    @Test
    public void testSum() {
        int expected = 15;
        int actual = sum.sumUpToN(5);

        assertEquals(expected, actual);
    }

}