package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfEvenNumbersTest {

    private final QuestionSumOfEvenNumbers sumOfEvenNumbers = new QuestionSumOfEvenNumbers();

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = sumOfEvenNumbers.sumOfEvenNumbers(numberList);

        assertEquals(30, result);
    }
}
