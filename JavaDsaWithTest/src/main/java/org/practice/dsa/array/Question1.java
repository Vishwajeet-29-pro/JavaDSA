package org.practice.dsa.array;

public class Question1 {

    /* Find the Second-Largest Number in an Array*/

    public int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) return Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i: arr) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second && i != first) {
                second = i;
            }
        }
        return second == Integer.MIN_VALUE ? Integer.MIN_VALUE : second;
    }
}
