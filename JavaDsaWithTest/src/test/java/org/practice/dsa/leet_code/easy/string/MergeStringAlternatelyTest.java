package org.practice.dsa.leet_code.easy.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeStringAlternatelyTest {

    private final QuestionMergeStrings mergeStrings = new QuestionMergeStrings();

    @Test
    public void testMergeStrings() {
        String word1 = "abc";
        String word2 = "pqr";
        String expected = "apbqcr";
        String actual = mergeStrings.mergeAlternately(word1, word2);

        assertEquals(expected, actual);
    }


    @Test
    public void testMergeString() {
        String word1 = "ab";
        String word2 = "pqrs";
        assertEquals("apbqrs", mergeStrings.mergeAlternately(word1, word2));
    }

    @Test
    public void testMergeStringForUnequalLength() {
        String word1 = "abcd";
        String word2 = "pq";
        assertEquals("apbqcd", mergeStrings.mergeAlternately(word1, word2));
    }
}
