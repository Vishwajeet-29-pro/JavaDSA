package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionsTest {
    Questions questions = new Questions();
    @Test
    void testFactorial() {
        int expected = 120;
        int result = questions.calculateFactorial(5);

        assertEquals(expected, result);
    }
}
