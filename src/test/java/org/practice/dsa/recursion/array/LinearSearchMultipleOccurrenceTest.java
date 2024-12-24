package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchMultipleOccurrenceTest {

    private final LinearSearchMultipleOccurrence multi = new LinearSearchMultipleOccurrence();

    @Test
    public void test_for_multiple_occurrence_should_return_list_indices() {
        int[] arr = {1,5,3,2,6,3};
        List<Integer> expected = List.of(2, 5);
        List<Integer> actual = multi.linearSearchMultipleOccurrence(arr, 3, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleOccurrenceByPassingListInFunctionCall() {
        int[] arr = {1, 3, 5, 2, 8, 0, 0};
        int target = 0;
        List<Integer> actual = multi.linearSearchMultiOccurrence(arr, target, 0, new ArrayList<>());

        assertEquals(List.of(5, 6), actual);
    }
}