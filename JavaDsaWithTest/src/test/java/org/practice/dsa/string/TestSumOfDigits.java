package org.practice.dsa.string;

import org.junit.jupiter.api.Test;
import org.practice.dsa.strings.QuestionSumOfDigitsFromString;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSumOfDigits {

    @Test
    void testSumOfDigits() {
        QuestionSumOfDigitsFromString sumOfDigitsFromString = new QuestionSumOfDigitsFromString();
        int result = sumOfDigitsFromString.sumOfDigits("a1b2c3");
        assertEquals(6, result);
    }
}
