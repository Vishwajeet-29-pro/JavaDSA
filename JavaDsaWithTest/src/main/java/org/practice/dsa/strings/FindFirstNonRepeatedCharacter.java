package org.practice.dsa.strings;

public class FindFirstNonRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeated("swiss"));
    }

    public static Character findFirstNonRepeated(String str) {
        int[] freq = new int[256];

        for (char c: str.toCharArray()) {
            freq[c]++;
        }

        for (char c: str.toCharArray()) {
            if (freq[c] == 1) {
                return c;
            }
        }
        return null;
    }
}
