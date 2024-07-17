package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVowelsTest {

    @Test
    void testCountVowels() {
        QuestionCountVowels vowels = new QuestionCountVowels();
        String input = "hello world";
        int result = vowels.countVowels(input);

        assertEquals(3, result);
    }
}
