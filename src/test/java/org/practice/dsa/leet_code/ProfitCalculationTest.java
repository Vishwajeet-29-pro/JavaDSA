package org.practice.dsa.leet_code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculationTest {

    @Test
    public void calculateProfit() {
        int[] prices = {7,1,5,3,6,4};
        int expectedOutput = 5;

        int result = QuestionProfitCalculation.maxProfit(prices);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void calculateProfit_() {
        int[] prices = {7,6,4,3,1};
        int expectedOutput = 0;

        int result = QuestionProfitCalculation.maxProfit(prices);
        assertEquals(expectedOutput, result);
    }
}
