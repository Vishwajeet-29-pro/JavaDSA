package org.practice.dsa.simple;

import java.util.Arrays;

/*
* An anagram of a string is another string that contains the same characters, only the order of characters can be different.
* */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("geeks", "skeeg"));
        System.out.println(isAnagram("ldlf", "lllf"));
    }

    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
