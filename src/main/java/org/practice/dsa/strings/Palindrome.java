package org.practice.dsa.strings;

public class Palindrome {
    public static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeTwoPointer(String str) {
        int start = 0;
        int end = str.length()-1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("any"));
        System.out.println("Using two pointer: "+isPalindromeTwoPointer("madam"));
    }
}
