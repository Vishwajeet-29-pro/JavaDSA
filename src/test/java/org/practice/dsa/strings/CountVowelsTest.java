package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVowelsTest {

    QuestionCountVowels vowels = new QuestionCountVowels();

    @Test
    void testCountVowels() {
        String input = "hello world";
        int result = vowels.countVowels(input);

        assertEquals(3, result);
    }

    @Test
    void testIfNoVowelReturnZero() {
        String input = "rhythm";
        int result = vowels.countVowels(input);

       assertEquals(0, result);
    }
}
