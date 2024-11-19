package org.practice.dsa.leet_code.easy.sorting;

public class ThirdMax {
    public static void main(String[] args) {
        int[] arr = {2,1,3};
        System.out.println(thirdMax(arr));;
    }

    public static int thirdMax(int[] nums) {

        sort(nums);
        int pointer =0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i == nums.length-1 || nums[i] !=nums[i+1]) {
                pointer++;
            }

            if (pointer == 3) {
                return nums[i];
            }
        }
        return nums[nums.length -1];
    }

    private static void sort(int[] nums) {
        boolean isSwap;

        for (int i = 0; i < nums.length-1; i++) {
            isSwap = false;
            for (int j = 1; j < nums.length -1- i; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1]  = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
