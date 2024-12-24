package org.practice.dsa.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesCharacters {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("Vishwajeet"));
        System.out.println(removeDuplicatesForLoop("principle"));
    }

    public static String removeDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (char ch: str.toCharArray()) {
            if (set.add(ch)) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    // using for loops
    public static String removeDuplicatesForLoop(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            boolean isDuplicate = false;

            for (int j = 0; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(j) == current) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }
}
