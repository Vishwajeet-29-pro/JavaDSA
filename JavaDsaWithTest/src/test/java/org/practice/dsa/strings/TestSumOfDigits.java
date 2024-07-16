package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSumOfDigits {

    @Test
    void testSumOfDigits() {
        QuestionSumOfDigitsFromString sumOfDigitsFromString = new QuestionSumOfDigitsFromString();
        int result = sumOfDigitsFromString.sumOfDigits("a1b2c3");
        assertEquals(6, result);
    }
}
