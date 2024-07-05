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

    private static String removeVowels(String input) {
        input = input.toLowerCase();
        var str = input.toCharArray();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
               str[i] = str[i+1];
            } else {
                output.append(str[i]);
            }
        }
        return output.toString();
    }
}
