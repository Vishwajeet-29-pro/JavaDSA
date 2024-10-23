package org.practice.dsa.recursion.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipCharacterTest {

    private SkipCharacter ch = new SkipCharacter();

    @Test
    public void testSkip() {
        String input = "baccad";
        String expected = "bccd";

        assertEquals("bccd", ch.skip(input));
    }
}