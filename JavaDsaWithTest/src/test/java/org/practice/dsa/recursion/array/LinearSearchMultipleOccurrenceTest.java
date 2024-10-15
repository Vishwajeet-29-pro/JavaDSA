package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

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
}