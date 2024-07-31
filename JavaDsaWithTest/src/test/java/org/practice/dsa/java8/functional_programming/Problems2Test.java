package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problems2Test {

    Problems2 problems = new Problems2();

    @Test
    public void testIntegersStartWithOne() {
        List<Integer> numbers =  List.of(10,22,32,11,15,34,67,35);
        List<Integer> expected = List.of(10,11,15);

        var result = problems.integersStartWithOne(numbers);
        assertEquals(expected, result);
    }
}
