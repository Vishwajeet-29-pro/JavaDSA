package org.practice.dsa.leet_code.easy.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};

//        System.out.println(Arrays.toString(insertion(arr1, arr2)));
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    public static int[] insertion(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < nums1.length && j< nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return list.stream().mapToInt(k ->k).toArray();
    }

    public static int[] merge(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int[] mix = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                mix[k] = num1[i];
                i++;
            } else {
                mix[k] = num2[j];
                j++;
            }
            k++;
        }
        while (i < num1.length) {
            mix[k] = num1[i];
            i++;
            k++;
        }

        while (j < num2.length) {
            mix[k] = num2[j];
            j++;
            k++;
        }
        return mix;
    }
}
