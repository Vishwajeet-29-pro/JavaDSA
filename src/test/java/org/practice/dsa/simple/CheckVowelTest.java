package org.practice.dsa.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckVowelTest {
    private final CheckVowel vowel = new CheckVowel();

    @Test
    public void testCheckVowelIsPresent() {
        assertTrue(vowel.checkStringContainsVowels("vishwajeet"));
        assertTrue(vowel.checkStringContainsVowels("simple"));
    }

    @Test
    public void testCheckVowelIfNotPresent() {
        assertFalse(vowel.checkStringContainsVowels("src"));
        assertFalse(vowel.checkStringContainsVowels("Rhythm"));
    }
}