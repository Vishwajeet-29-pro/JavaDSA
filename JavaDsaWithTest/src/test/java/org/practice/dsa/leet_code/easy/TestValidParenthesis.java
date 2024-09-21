package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidParenthesis {
    private final QuestionValidParenthesis parenthesis = new QuestionValidParenthesis();

    @Test
    public void testValidParenthesis() {
        String s = "()";
        assertTrue(parenthesis.isValid(s));
    }
}
