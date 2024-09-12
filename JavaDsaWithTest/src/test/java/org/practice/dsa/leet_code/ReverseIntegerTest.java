package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    private final QuestionReverseInteger reverseInteger = new QuestionReverseInteger();

    @Test
    public void testReverseInteger() {
        int input = 123;
        int expected = 321;
        int actual = reverseInteger.reverse(input);
        assertEquals(expected, actual);
    }
}
