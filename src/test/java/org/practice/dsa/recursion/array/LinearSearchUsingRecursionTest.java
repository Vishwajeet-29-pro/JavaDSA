package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchUsingRecursionTest {

    private final LinearSearchUsingRecursion search = new LinearSearchUsingRecursion();

    // test creation steps went wrong, i.e. false condition should need to handle first.
    @Test
    public void test_when_target_found_should_return_true() {
        int[] arr = {1, 6, 3, 0, 7, 4};
        int target = 6;

        assertTrue(search.findElement(arr, target, 0));
    }

    @Test
    public void test_when_target_not_found_should_return_false() {
        int[] arr = {1,5,3,2,9};
        int target = 8;

        assertFalse(search.findElement(arr, target, 0));
    }

    @Test
    public void test_when_target_not_found_should_return_minus_one() {
        int[] arr = {1, 3, 6, 2, 4};
        int target = 9;

        assertEquals(-1, search.findElementAndReturnIndex(arr, target, 0));
    }

    @Test
    public void test_when_target_found_return_index() {
        int[] arr = {1, 3, 2, 5, 6};
        int target = 3;

        assertEquals(1, search.findElementAndReturnIndex(arr, target, 0));
    }
}
