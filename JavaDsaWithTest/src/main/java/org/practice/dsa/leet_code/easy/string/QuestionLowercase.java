package org.practice.dsa.leet_code.easy.string;

public class QuestionLowercase {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                 result.append((char) (s.charAt(i) + 32));
            } else result.append(s.charAt(i));
        }


        return result.toString();
    }
}
