package org.practice.dsa.leet_code.easy;

import java.util.*;

public class QuestionRomanToInteger {
    /*
    * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

        Example 1:
        Input: s = "III"
        Output: 3
        Explanation: III = 3.

        Example 2:
        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.

        Example 3:
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

        Constraints:

        1 <= s.length <= 15
        s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
        It is guaranteed that s is a valid roman numeral in the range [1, 3999].
    * */

    public int romanToInt(String s) {

        Map<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        int result = 0;
        if (s.length() == 1) {
            return romanNumbers.get(s.charAt(0));
        }

        for (int i = 0; i < s.length(); i++) {
          if (i != s.length() -1 ) {
              if (romanNumbers.get(s.charAt(i)) < romanNumbers.get(s.charAt(i+1))) {
                  result += romanNumbers.get(s.charAt(i+1)) - romanNumbers.get(s.charAt(i));
                  i++;
              } else if (romanNumbers.get(s.charAt(i)) >= romanNumbers.get(s.charAt(i+1))) {
                  result += romanNumbers.get(s.charAt(i));
                  System.out.println("Result in else if block after calc: "+result);
              }
          } else {
              result += romanNumbers.get(s.charAt(s.length()-1));
              System.out.println("Result in else block after calc: "+result);
          }
        }
        System.out.println("Final Result "+result);
        return result;
    }

    public int optimizedRomanToInt(String s) {
        Map<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        int result = 0;

//        for (int i = 0; i < s.length() -1; i++) {
//            int currentValue = romanNumbers.get(s.charAt(i));
//
//            if (i < s.length() - 1 && currentValue < romanNumbers.get(s.charAt(i+1))) {
//                result -= currentValue;
//            } else {
//                result += currentValue;
//            }
//        }
        int i = 0;
        while (i < s.length()) {
            int currentValue = romanNumbers.get(s.charAt(i));
            if (i < s.length() - 1 && currentValue < romanNumbers.get(s.charAt(i+1))) {
                result -= currentValue;
                i++;
            } else {
                result += currentValue;
                i++;
            }
        }
    return result;
    }
}
