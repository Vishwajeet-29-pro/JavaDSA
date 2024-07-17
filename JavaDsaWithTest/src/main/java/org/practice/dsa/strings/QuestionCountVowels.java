package org.practice.dsa.strings;

public class QuestionCountVowels {
    public int countVowels(String input) {
        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}
