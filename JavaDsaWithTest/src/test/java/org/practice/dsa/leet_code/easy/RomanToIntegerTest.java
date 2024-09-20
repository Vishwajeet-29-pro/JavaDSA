package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {
    private final QuestionRomanToInteger roman = new QuestionRomanToInteger();

    @Test
    public void testRomanToInteger() {
        String s = "III";
        int expected = 3;
        assertEquals(expected, roman.romanToInt(s));
    }
}
