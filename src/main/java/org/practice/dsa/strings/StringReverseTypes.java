package org.practice.dsa.strings;

import java.util.Arrays;

public class StringReverseTypes {
    public static void main(String[] args) {
       var res = reverseString("I am a Student");
        System.out.println(res);
        System.out.println(res("Today is a Very great day"));
    }

//
//    Input: Today is a Very great Day.
//    Output: Very Today is great Day a

    public static String res(String input) {
        String[] words = input.split(" ");

        Arrays.sort(words, (a, b) -> b.compareToIgnoreCase(a));
        return String.join(" ", words);
    }

    // I am a Student
    // Student a am I
    public static String reverseString(String input) {
        StringBuilder builder = new StringBuilder();
        String reverse = "";
//        char[] words = input.toCharArray();
        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            reverse = reverse + words[i] + " ";
        }
        return reverse;
    }
}
