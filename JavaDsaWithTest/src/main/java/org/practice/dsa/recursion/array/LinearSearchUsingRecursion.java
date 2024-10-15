package org.practice.dsa.recursion.array;

public class LinearSearchUsingRecursion {

    public boolean findElement(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }

        return arr[index] == target || findElement(arr, target, index + 1);
    }
}
