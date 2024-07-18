package org.practice.dsa.strings;

public class QuestionIsRotationStrings {
    public boolean isRotation(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }

        String concatenate = stringOne + stringTwo;
        return concatenate.contains(stringTwo);
    }
}
