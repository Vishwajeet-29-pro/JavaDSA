package org.practice.dsa.strings;

import java.util.Arrays;

public class QuestionReverseOrderString {
    public String reverseWords(String str) {
        String[] words = str.split("\\s+"); // Split by whitespace, handling multiple spaces

        // Step 2: Reverse the array of words using a for loop
        int n = words.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = words[i];
            words[i] = words[n - i - 1];
            words[n - i - 1] = temp;
        }

        // Step 3: Join the reversed array back into a single string
        StringBuilder reversedString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            reversedString.append(words[i]);
            if (i < words.length - 1) {
                reversedString.append(" "); // Append space between words
            }
        }

        // Step 4: Return the reversed string
        return reversedString.toString();
    }
}
