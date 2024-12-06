package org.practice.dsa.simple;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        System.out.println(missing(arr));
    }

    public static int missing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i+1] != arr[i]+1) {
                return arr[i]+1;
            }
        }
        return 0;
    }
}
