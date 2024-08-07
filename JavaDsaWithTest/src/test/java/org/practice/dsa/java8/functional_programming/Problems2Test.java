package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }

    /*Given the list of integers, find the first element of the list using Stream functions?*/
    @Test
    public void testFindFirstElementOfList() {
        List<Integer> integers = List.of(1,2,3,5,6);
        int expected = 1;

        int result =  problems.findFirstElementOfList(integers);
        assertEquals(expected, result);
    }

    /*Given a list of integers, find the total number of elements present in the list using Stream functions*/
    @Test
    public void testFindTotalNumber() {
        List<Integer> integers = List.of(1,2,3,5,6);
        int expected = 5;

        long result = problems.findTotalNumber(integers);
        assertEquals(expected, result);
    }

    /*Given a list of integers, find the maximum value element present in it using Stream functions?*/
    @Test
    public void testFindMaximum() {
        List<Integer> list = List.of(1,2,3,4,5);
        assertEquals(5, problems.findMaxFromList(list));
        List<Integer> list2 = List.of(-1, -1);
        assertEquals(-1, problems.findMaxFromList(list2));

        List<Integer> list3 = List.of();
        var exception = assertThrows(IllegalArgumentException.class,() -> {
            problems.findMaxFromList(list3);
        });

        assertEquals("Empty list", exception.getMessage());
    }

    /*Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions.*/
    @Test
    public void testRemoveDuplicatesFromList() {
        List<Integer> list = List.of(1,2,2,4,3,3,6,6,6);
        List<Integer>  result = problems.removeDuplicates(list);
        result.forEach(System.out::print);
        assertEquals(5,result.size());
    }

    /*Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.*/
    @Test
    public void testFrequencyOfElements(){
        List<Integer> list = List.of(1,2,2,4,3,3,6,6,6);
        Map<Integer, Long> output = problems.frequencyOfElements(list);
        output.forEach((a,b) -> System.out.println(a+" -> "+b));
        Map<Integer, Integer> map = Map.of(1,1,2,2,4,1,3,2,6,3);
        assertEquals(output.size(), map.size());
    }
}
