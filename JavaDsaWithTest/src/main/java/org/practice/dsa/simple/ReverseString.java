package org.practice.dsa.simple;

public class ReverseString {
    public String reverseString(String input) {
        if (input.isEmpty()) throw new RuntimeException("Empty string passed");

        StringBuilder builder = new StringBuilder();
        char[] chars = input.toCharArray();

        for(int i = chars.length -1; i >=0; i-- )   {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
