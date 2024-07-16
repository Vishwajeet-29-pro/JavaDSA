package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReverseOrderString {

    private QuestionReverseOrderString reverseOrderString;
    @Test
    void testReverserOrderString() {
        reverseOrderString = new QuestionReverseOrderString();
        String result = reverseOrderString.reverseWords("hello world how are you");
        String expected = "you are how world hello";

        assertEquals(expected, result);

    }
}
