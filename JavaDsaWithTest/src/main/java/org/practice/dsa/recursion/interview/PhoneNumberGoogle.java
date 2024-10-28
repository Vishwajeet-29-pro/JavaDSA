package org.practice.dsa.recursion.interview;

public class PhoneNumberGoogle {
    // This question asked in the Google interview
    // let's start with basic implementation and then will update code according to leet code

    public static void main(String[] args) {
//        phoneNumber("", "12");
        phoneNumber("","1");
    }
    // p = processed, up = unprocessed
    public static void phoneNumber(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert char to int

        int endIndex = (digit == 9) ? 26 : digit * 3;
        for (int i = (digit -1) * 3; i < endIndex; i++) {
            char ch = (char) ('a' + i);
            phoneNumber(p + ch, up.substring(1));
        }
    }
}
