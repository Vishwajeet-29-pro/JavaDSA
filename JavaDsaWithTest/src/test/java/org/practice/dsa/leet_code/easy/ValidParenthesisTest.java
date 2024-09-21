package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesisTest {
    private final QuestionValidParenthesis parenthesis = new QuestionValidParenthesis();

    @Test
    public void testValidParenthesis() {
        String s = "()";
        assertTrue(parenthesis.isValid(s));
    }

    @Test
    public void testValidParenthesisForMultipleBrackets() {
        String s = "(){}[]";
        assertTrue(parenthesis.isValid(s));
    }

    @Test
    public void testValidParenthesisForWrongMatch() {
        String s = "(}";
        assertFalse(parenthesis.isValid(s));
    }

    @Test
    public void testMultipleAssertions() {
       assertAll("Valid Parenthesis",() -> {
           assertTrue(parenthesis.isValid("([])"));
           assertFalse(parenthesis.isValid("(}[){]"));
       });
    }

    @Test
    public void testIncompleteParenthesis() {
        assertFalse(parenthesis.isValid("(){}}{"));
    }
}
