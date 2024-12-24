package org.practice.dsa.recursion.easy;

public class Power {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 1) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n/3);
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        return isPowerOfThree(n/4);
    }
}
