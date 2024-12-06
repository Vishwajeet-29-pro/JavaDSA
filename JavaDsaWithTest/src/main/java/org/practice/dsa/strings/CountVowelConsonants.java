package org.practice.dsa.strings;

public class CountVowelConsonants {
    public static void main(String[] args) {
        countVowelConsonants("Vishwajeet");
    }

    public static void countVowelConsonants(String str) {
        int vCount = 0;
        int cCount = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vCount++;
            } else {
                cCount++;
            }
        }
        System.out.println("The Vowel Count is: "+vCount+" and Consonant count is: "+cCount);
    }
}
