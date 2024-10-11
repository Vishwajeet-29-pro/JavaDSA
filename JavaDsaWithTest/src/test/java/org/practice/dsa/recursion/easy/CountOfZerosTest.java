package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOfZerosTest {

    private final CountOfZeros zeros = new CountOfZeros();

    @Test
    public void testCountZero() {
        int expected = 2;
        int actual = zeros.countZero(303430);

        assertEquals(expected, actual);
    }

}