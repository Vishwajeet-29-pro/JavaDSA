package org.practice.dsa.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchMultipleOccurrence {

    // In this approach with each recursive function call we are creating a new list, which is not good solution
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

    public List<Integer> linearSearchMultiOccurrence(int[] arr, int target, int index, List<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return linearSearchMultiOccurrence(arr, target, index + 1, list);
    }
}
