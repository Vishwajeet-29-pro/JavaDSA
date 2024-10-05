package org.practice.dsa.leet_code.easy.string;

import org.junit.jupiter.api.Test;

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
}
