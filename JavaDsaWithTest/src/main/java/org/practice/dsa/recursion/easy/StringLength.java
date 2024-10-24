package org.practice.dsa.recursion.easy;

public class StringLength {
    public static int length(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return length(s.substring(1)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(length("Intellij"));
    }
}
