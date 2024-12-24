package org.practice.dsa.simple;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateTest {

    private final FindDuplicate duplicate = new FindDuplicate();

    @Test
    public void testDuplicatePresent() {
        int[] arr = {1, 1, 2, 3, 4};
        boolean expected = true;

        assertEquals(expected, duplicate.findDuplicateElement(arr));
    }
}