package org.practice.dsa.strings;

public class CapitalizeFirstChar {
    public static void main(String[] args) {
        System.out.println(capitalize("hello world"));
        System.out.println(capitalizeEach("hello world"));
    }

    // only first letter of first word
    public static String capitalize(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // first letter of all words
    public static String capitalizeEach(String str) {
        if (str.isEmpty()) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word: words) {
            if (!word.isEmpty()) {
                result.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }
}
