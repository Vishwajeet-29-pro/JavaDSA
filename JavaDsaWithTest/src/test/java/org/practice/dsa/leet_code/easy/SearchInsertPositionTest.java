package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {
    private final QuestionSearchInsertPosition insertPosition = new QuestionSearchInsertPosition();

    int[] arr = {1,3,5,7};

    @Test
    public void testSearchInsert() {

        int target = 5;
        int expected = 2;
        int actual = insertPosition.searchInsert(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchInsertForSmallerNumber() {
        int target = 2;
        int expected = 1;
        int actual = insertPosition.searchInsert(arr, target);
        assertEquals(expected, actual);
    }
}
