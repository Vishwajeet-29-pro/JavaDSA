package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionProfitCalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculationTest {

    @Test
    public void calculateProfit() {
        int[] prices = {7,1,5,3,6,4};
        int expectedOutput = 5;

        int result = QuestionProfitCalculation.maxProfit(prices);
        assertEquals(expectedOutput, result);
    }
}
