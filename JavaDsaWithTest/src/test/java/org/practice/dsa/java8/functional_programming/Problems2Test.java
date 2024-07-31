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

    /*How to find duplicate elements in a given integers list in java using Stream functions*/
    @Test
    public void testFindDuplicatesFromList() {
        List<Integer> list = List.of(1,1,2,3,4,4,5,6,6,6);
        List<Integer> expected = List.of(1,4,6);

        List<Integer> result = problems.findDuplicatesFromList(list);
        result.forEach(System.out::print);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }
}
