package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {
    private final QuestionSearchInsertPosition insertPosition = new QuestionSearchInsertPosition();

    int[] arr = {1,3,5,6};

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

    @Test
    public void testSearchInsertForBiggerNumber() {
        int target = 7;
        int expected = 4;
        assertEquals(expected, insertPosition.searchInsert(arr, target));
    }

    @Test
    public void testSearchInsertForZeroIndex() {
        int target = 0;
        int expected = 0;
        assertEquals(expected, insertPosition.searchInsert(arr, target));
    }
}
