package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Problem3Test {

    private final Problems3 problem = new Problems3();

    /*Given a list of integers, sort all the values present in it in descending order using Stream functions?*/
    @Test
    public void testReverseOrder() {
        List<Integer> list = List.of(1,2,3,4,5,6);
        List<Integer> expected = List.of(6,5,4,3,2,1);

        List<Integer> result = problem.sortListInReverseOrder(list);
        assertEquals(expected, result);
    }

    /*Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    every element is distinct*/
    @Test
    public void test(){
        int[] arr = new int[] {1,2,3,1};
        assertTrue(problem.validateArray(arr));
        int[] inputs = new int[] {1,2,3,4};
        assertFalse(problem.validateArray(inputs));
    }

    /*Write a Java 8 program to concatenate two Streams*/
    @Test
    public void testTwoStringListsConcatenation() {
        List<String> s1 = List.of("Hello");
        List<String> s2 = List.of("World");
        assertEquals(List.of("Hello", "World"),problem.concateTwoStringLists(s1, s2));
    }
}
