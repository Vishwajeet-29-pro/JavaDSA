package org.practice.dsa.leet_code;

public class QuestionAtoIAlgorithm {
    /*. String to Integer (atoi)

    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

    The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the
    string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain
    in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should
    be rounded to 231 - 1.
    Return the integer as the final result.

    Example 1:
    Input: s = "42"
    Output: 42
    Explanation:
    The underlined characters are what is read in and the caret is the current reader position.
    Step 1: "42" (no characters read because there is no leading whitespace)
             ^
    Step 2: "42" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "42" ("42" is read in)
               ^
    Example 2:
    Input: s = " -042"
    Output: -42
    Explanation:
    Step 1: "   -042" (leading whitespace is read and ignored)
                ^
    Step 2: "   -042" ('-' is read, so the result should be negative)
                 ^
    Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
                   ^
    Example 3:
    Input: s = "1337c0d3"
    Output: 1337
    Explanation:
    Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
             ^
    Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
                 ^
    Example 4:
    Input: s = "0-1"
    Output: 0
    Explanation:
    Step 1: "0-1" (no characters read because there is no leading whitespace)
             ^
    Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
              ^
    Example 5:
    Input: s = "words and 987"
    Output: 0
    Explanation:
    Reading stops at the first non-digit character 'w'.
    */

    public int myAtoi(String s) {
        s = s.trim();  // Step 1: Trim leading/trailing spaces
        if (s.isEmpty()) return 0;  // Return 0 if string is empty

        int i = 0, sign = 1, result = 0;

        // Step 2: Handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        // Step 3: Convert digits to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';

            // Step 4: Check for overflow/underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
        }
        // Step 5: Return final result with the correct sign
        return result * sign;
    }
}
