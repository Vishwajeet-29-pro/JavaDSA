package org.practice.dsa.leet_code.easy.string;

public class QuestionMergeStrings {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder builder = new StringBuilder();
        int wordLength = 0;
        int word1Length = word1.length();
        int word2Length = word2.length();

        wordLength = Math.max(word1Length, word2Length);

        for (int i = 0; i < wordLength; i++) {
            if (i < word1Length) {
                builder.append(word1.charAt(i));
            }
            if (i < word2Length) {
                builder.append(word2.charAt(i));
            }
        }

        return builder.toString();
    }
}
