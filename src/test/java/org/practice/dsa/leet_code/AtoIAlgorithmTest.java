package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtoIAlgorithmTest {
    private QuestionAtoIAlgorithm algorithm = new QuestionAtoIAlgorithm();

    /*
    Example 1:
    Input: s = "42"
    Output: 42
    Explanation:
    The underlined characters are what is read in and the caret is the current reader position.
    Step 1: "42" (no characters read because there is no leading whitespace)
             ^
    Step 2: "42" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "42" ("42" is read in)
               ^
    */
    @Test
    public void testAlgorithm() {
        String input = "42";
        int expected = 42;
        int actual = algorithm.myAtoi(input);
        assertEquals(expected, actual);
    }
}
