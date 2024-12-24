package org.practice.dsa.recursion.interview;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberGoogle {
    // This question asked in the Google interview
    // let's start with basic implementation and then will update code according to leet code

    public static void main(String[] args) {
//        phoneNumber("", "12");
//        phoneNumber("","1");
//        System.out.println(phoneNumberList("", "1"));
//        System.out.println(phoneCountCombinations("", "123"));
//        phoneNumberLeet("", "99");
//        System.out.println(phoneNumberLeetReturn("", "23"));
        System.out.println(letterCombination("8"));
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

    public static ArrayList<String> phoneNumberList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        int endIndex = (digit == 9) ? 26 : digit * 3;
        for (int i = (digit -1) *3; i < endIndex; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(phoneNumberList(p + ch, up.substring(1)));
        }
        return ans;
    }

    public static int phoneCountCombinations(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        int endIndex = (digit == 9) ? 26 : digit * 3;
        for (int i = (digit - 1) *3; i < endIndex; i++) {
           char ch = (char) ('a' + i);
           count = count + phoneCountCombinations(p + ch, up.substring(1));
        }
        return count;
    }

    public static void phoneNumberLeet(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert char to int

        if (digit <= 1) {
            return;
        }

        int startIndex;
        int endIndex;

        if (digit == 7) {
            startIndex = 15;
            endIndex = 19;
        } else if (digit == 9) {
            startIndex = 22;
            endIndex = 26;
        } else {
            startIndex = (digit - 2) * 3;
            endIndex = startIndex + 3;
        }

        for (int i = startIndex; i < endIndex; i++) {
            char ch = (char) ('a' + i);
            phoneNumber(p + ch, up.substring(1));
        }
    }

    private static final String[] KEYPAD = {
            "",     // 0 (no letters)
            "",     // 1 (no letters)
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public static List<String> letterCombination(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no digits
        }
        return phoneNumberLeetReturn("", digits);
    }

    public static List<String> phoneNumberLeetReturn(String prefix, String remainingDigits) {
        // Base case: when remainingDigits is empty, return the accumulated prefix
        if (remainingDigits.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            result.add(prefix);
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        int digit = remainingDigits.charAt(0) - '0'; // Convert first character to integer

        // Get the corresponding letters for the digit from KEYPAD array
        String letters = KEYPAD[digit];

        // Skip processing if digit has no letters (e.g., 0 or 1)
        if (letters.isEmpty()) {
            return phoneNumberLeetReturn(prefix, remainingDigits.substring(1));
        }

        // Recursively build combinations with each letter
        for (char letter : letters.toCharArray()) {
            result.addAll(phoneNumberLeetReturn(prefix + letter, remainingDigits.substring(1)));
        }
        return result;
    }
}
