package org.practice.dsa.leet_code.easy.sorting;

import java.util.Arrays;

public class HeightMismatch {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int mismatch = 0;
        for (int i = 0; i <heights.length; i++) {
            if (expected[i] != heights[i]) {
                mismatch++;
            }
        }
        return mismatch;
    }
}
