package org.practice.dsa.leet_code.easy.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayStringEqualsTest {

    private final QuestionArrayStringEquals stringEquals = new QuestionArrayStringEquals();

    @Test
    public void testArrayStringsEquals() {
        String[] input1 = {"ab", "c"};
        String[] input2 = {"a", "bc"};
        boolean result = stringEquals.arrayStringsAreEqual(input1, input2);
        assertTrue(result);
    }

    @Test
    public void testArrayStringsNotEqual() {
        String[] word1 = {"a","bc"};
        String[] word2 = {"a","cb"};
        assertFalse(stringEquals.arrayStringsAreEqual(word1, word2));
    }

    @Test
    public void testArrayStringsEqualForSingleWord() {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        assertTrue(stringEquals.arrayStringsAreEqual(word1, word2));
    }
}
