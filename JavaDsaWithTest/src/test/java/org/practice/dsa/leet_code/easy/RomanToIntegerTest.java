package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {
    private final QuestionRomanToInteger roman = new QuestionRomanToInteger();

    @Test
    public void testRomanToInteger() {
        String s = "III";
        int expected = 3;
        assertEquals(expected, roman.optimizedRomanToInt(s));
    }

    @Test
    public void testRomanNumberGreaterThanFirstOne() {
        String s = "CCI";
        int expected = 201;
        assertEquals(expected, roman.optimizedRomanToInt(s));
    }

    @Test
    public void testSubtractMethod() {
        int expected = 9;
        assertEquals(expected, roman.optimizedRomanToInt("IX"));
    }

    @Test
    public void testIfStringContainOnlyOneRomanNumber() {
        int expected = 100;
        assertEquals(expected, roman.optimizedRomanToInt("C"));
    }

    @Test
    public void testBiggerNumber() {
        String s = "MCMXCIV";
        int expected = 1994;

        assertEquals(expected, roman.optimizedRomanToInt(s));
    }

    @Test
    public void testRomanNumberLVIII() {
        String s = "LVIII";
        int expected = 58;

        assertEquals(expected, roman.optimizedRomanToInt(s));
    }
}
