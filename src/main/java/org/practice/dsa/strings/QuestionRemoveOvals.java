package org.practice.dsa.strings;

import java.util.Locale;

public class QuestionRemoveOvals {
    /*
    You are given a string s consisting of lowercase English letters. Your task is to remove all vowels
    (a, e, i, o, u) from the string and return the new string.
    Implement a function String removeVowels(String s) that returns the string after removing all vowels.
    */

    public static void main(String[] args) {
        String input = "Question";
        String output = removeVowels(input);
        System.out.println(output);
    }

    public static String removeVowels(String input) {
        input = input.toLowerCase();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch !='a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                output.append(ch);
            }
        }
        return output.toString();
    }
}
