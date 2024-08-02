package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem3Test {

    private Problems3 problem = new Problems3();

    /*Given a list of integers, sort all the values present in it in descending order using Stream functions?*/
    @Test
    public void testReverseOrder() {
        List<Integer> list = List.of(1,2,3,4,5,6);
        List<Integer> expected = List.of(6,5,4,3,2,1);

        List<Integer> result = problem.sortListInReverseOrder(list);
        assertEquals(expected, result);
    }
}
