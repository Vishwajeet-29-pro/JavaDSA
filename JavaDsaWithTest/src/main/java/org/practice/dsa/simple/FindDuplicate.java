package org.practice.dsa.simple;

public class FindDuplicate {

    // for already sorted array
    public boolean findDuplicateElement(int[] arr) {

        for (int i = 1; i <arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
