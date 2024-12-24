package org.practice.dsa.strings;

public class StringReverse {
    public static String reverseString(String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = str.length()-1; i >=0 ; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Practical"));
    }
}
