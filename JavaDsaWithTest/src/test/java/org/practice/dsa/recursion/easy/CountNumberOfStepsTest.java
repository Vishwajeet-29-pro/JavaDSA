package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CountNumberOfStepsTest {

    private final CountNumberOfSteps steps = new CountNumberOfSteps();

    @Test
    public void testNumberOfSteps() {
        int expected = 6;
        int actual = steps.numberOfSteps(11);

        assertEquals(expected, actual);
    }
  
}