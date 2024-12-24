package org.practice.dsa.java8.filter;

import java.util.List;

public class FilterTwo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,2,3,4,5,6,6);
        System.out.println(removeDuplicate(list));

        List<String> stringList = List.of("madam", "level", "Two", "filter", "racecar");
        System.out.println(palindromeFilter(stringList));
    }

    // Filter Duplicate elements
    // no need of filter method
    public static List<Integer> removeDuplicate(List<Integer> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    // Filter the palindrome string
    public static List<String> palindromeFilter(List<String> list) {
        return list.stream()
                .filter(FilterTwo::isPalindrome)
                .toList();
    }

    private static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

}
