package org.practice.dsa.simple;

public class CheckVowel {
    public boolean checkStringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
