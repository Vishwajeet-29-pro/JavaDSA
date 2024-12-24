package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.easy.bs.QuestionArrangeCoins;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrangeCoinTest {
    private final QuestionArrangeCoins arrangeCoins = new QuestionArrangeCoins();

    @Test
    public void testArrangeCoins() {
        int expected = 2;
        int actual = arrangeCoins.arrangeCoins(5);

        assertEquals(expected, actual);
    }

    @Test
    public void testArrangeCoinsFor8() {
        int expected = 3;
        int actual = arrangeCoins.arrangeCoins(8);
        assertEquals(expected, actual);
    }
}
