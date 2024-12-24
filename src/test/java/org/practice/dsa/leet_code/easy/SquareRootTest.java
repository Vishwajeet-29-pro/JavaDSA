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

    @Test
    public void testSquareRootForEight() {
        int input = 8;
        int expected = 2;
        assertEquals(expected, squareRoot.mySqrt(input));
    }

    @Test
    public void testMultipleSquareRoots() {
        assertEquals(3, squareRoot.mySqrt(9));
        assertEquals(3, squareRoot.mySqrt(10));
        assertEquals(6, squareRoot.mySqrt(36));
        assertEquals(6, squareRoot.mySqrt(37));
    }

    @Test
    public void testLeetCodeTests() {
        System.out.println(squareRoot.mySqrt(2147395599));
        assertEquals(46339,squareRoot.mySqrt(2147395599));
    }
}

