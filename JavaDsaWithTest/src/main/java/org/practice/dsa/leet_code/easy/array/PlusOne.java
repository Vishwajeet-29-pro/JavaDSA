package org.practice.dsa.leet_code.easy.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digit = {9};
//        System.out.println("Expected : [1, 2, 4]");
        System.out.println(Arrays.toString(plusOne(digit)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
