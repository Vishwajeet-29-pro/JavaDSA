package org.practice.dsa.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    private final ReverseString rs = new ReverseString();

    @Test
    public void testReverseStringIfEmptyInput() {
        Exception exception = assertThrows(RuntimeException.class, () -> rs.reverseString(""));
        assertEquals("Empty string passed", exception.getMessage());
    }

    @Test
    public void testReverseString() {
        String input = "simple";
        assertEquals("elpmis", rs.reverseString(input));
    }
}