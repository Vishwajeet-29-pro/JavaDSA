package org.practice.dsa.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveBinarySearchTest {

    private RecursiveBinarySearch bs = new RecursiveBinarySearch();

    @Test
    public void testRecursiveBs(){
        int[] arr = {1,2,3,5,6,22,343,132,753};
        int target = 343;
        int actual = bs.binarySearch(arr, target, 0, arr.length-1);
        assertEquals(6, actual);
    }

}