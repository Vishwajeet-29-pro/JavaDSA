package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.easy.string.QuestionLowercase;

import static org.junit.jupiter.api.Assertions.*;

class LowercaseTest {

    private final QuestionLowercase lowercase = new QuestionLowercase();

    @Test
    public void testLowerCase() {
        String input = "STATIC";
        String expected = "static";
        assertEquals(expected, lowercase.toLowerCase(input));
    }

    @Test
    public void testLowerCaseForSmallCase() {
        String input = "here";
        String expected = "here";
        assertEquals(expected, lowercase.toLowerCase(input));
    }

    @Test
    public void testLowerCaseForCamelCase() {
        String input = "Hello";
        String expected = "hello";
        assertEquals(expected, lowercase.toLowerCase(input));
    }

}