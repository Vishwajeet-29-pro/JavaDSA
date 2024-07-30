package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionsTest {

    @Test
    void testFactorial() {
        int expected = 150;
        int result = Questions.calculateFactorial(5);

        assertEquals(expected, result);
    }
}
