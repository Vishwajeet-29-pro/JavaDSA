package org.practice.dsa.recursion.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchUsingRecursionTest {

    private final LinearSearchUsingRecursion search = new LinearSearchUsingRecursion();

    @Test
    public void test_when_target_found_should_return_true() {
        int[] arr = {1, 6, 3, 0, 7, 4};
        int target = 6;

        assertTrue(search.findElement(arr, target, 0));
    }
}
