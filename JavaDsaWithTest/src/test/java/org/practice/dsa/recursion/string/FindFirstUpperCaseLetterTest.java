package org.practice.dsa.recursion.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstUpperCaseLetterTest {

    private final FindFirstUpperCaseLetter letter = new FindFirstUpperCaseLetter();

    @Test
    public void testUpperCaseLetter() {
        String s = "GeeksForGeeks";
        char expected = 'G';
        assertEquals(expected, letter.find(s,0));
    }

    @Test
    public void testUpperCaseLetterFromString() {
        String s = "vishwajeeT";
        char expected = 'T';
        assertEquals(expected, letter.find(s, 0));
    }
}