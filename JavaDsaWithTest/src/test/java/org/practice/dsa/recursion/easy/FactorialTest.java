package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private final Factorial factorial = new Factorial();

    @Test
    public void testFactorial() {
        int expected = 120;
        int actual = factorial.fact(5);

        assertEquals(expected, actual);
    }

    @Test
    public void testFactorialOfZeroShouldReturnOne() {
        int expected = 1;
        int actual = factorial.fact(0);

        assertEquals(expected, actual);
    }
}
