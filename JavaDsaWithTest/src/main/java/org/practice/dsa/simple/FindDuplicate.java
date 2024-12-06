package org.practice.dsa.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicate {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,3,3,4};
//        System.out.println(removeDuplicate(arr));
        int[] nums = {1, 2, 2, 3, 3, 4, 5, 5};

        int newLength = removeDuplicate(nums);

        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    // for already sorted array
    public boolean findDuplicateElement(int[] arr) {

        for (int i = 1; i <arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static int removeDuplicate(int[] arr) {
        int uniqueIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr[uniqueIndex] = arr[i];
                uniqueIndex++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return uniqueIndex;
    }
}
