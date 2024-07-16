package org.practice.dsa.strings;

public class QuestionSumOfDigitsFromString {
    public int sumOfDigits(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)){
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
}
