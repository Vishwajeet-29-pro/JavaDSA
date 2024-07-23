package org.practice.dsa.leet_code_test;

import org.junit.jupiter.api.Test;
import org.practice.dsa.leet_code.QuestionMergeStoredArrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeStoredArraysTest {

    @Test
    public void testMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};

        QuestionMergeStoredArrays.merge(nums1,m,nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testMergeWithNoElementsInNums1() {
        int[] nums1 = {0,0,0};
        int m = 0;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] expected = {2,5,6};

        QuestionMergeStoredArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testNoElementsInNums2() {
        int[] nums1 = {1,2,5};
        int m = 3;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1,2,5};

        QuestionMergeStoredArrays.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}
