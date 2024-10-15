package org.practice.dsa.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchMultipleOccurrence {

    public List<Integer> linearSearchMultipleOccurrence(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        List<Integer> all = linearSearchMultipleOccurrence(arr, target, index + 1);
        list.addAll(all);
        return list;
    }
}
