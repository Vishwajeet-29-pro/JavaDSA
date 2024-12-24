package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberRecursionTest {

    private final ReverseNumberRecursion recursion = new ReverseNumberRecursion();

    @Test
    public void testReverseNumber() {
        int expected = 4281;
        int input = 1824;
        recursion.reverseNumber(input);

        assertEquals(expected, recursion.sum);
    }

    @Test
    public void testReverseNumberWithOtherWay() {
        int expected = 4281;
        int actual = recursion.reverseNumberUsingRecursionWithHelperMethod(1824);

        assertEquals(expected, actual);
    }
}