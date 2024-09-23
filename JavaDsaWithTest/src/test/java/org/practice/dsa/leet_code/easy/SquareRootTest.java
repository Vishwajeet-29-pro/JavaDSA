package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {
    private final QuestionSquareRoot squareRoot = new QuestionSquareRoot();

    @Test
    public void testSquareRootForAbsoluteValue() {
        int input = 4;
        int expected = 2;
        int result = squareRoot.mySqrt(input);
        assertEquals(expected, result);
    }
}

