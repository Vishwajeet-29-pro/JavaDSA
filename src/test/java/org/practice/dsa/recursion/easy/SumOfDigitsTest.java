package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {
    private final SumOfDigits sum = new SumOfDigits();

    @Test
    public void testSumOfDigits() {
        int expected = 10;
        int actual = sum.sumOfDigits(1342);

        assertEquals(expected, actual);
    }

}