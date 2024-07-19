package org.practice.dsa.java8.lambda_expression;

import org.junit.jupiter.api.Test;
import org.practice.dsa.java8.lamdba_expressions.QuestionCalculateMaximumFromList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumFromListTest {

    @Test
    void testMaximumFromList() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        Optional<Integer> result = QuestionCalculateMaximumFromList.maximumElement(list);

        assertEquals(8, result);
    }
}
