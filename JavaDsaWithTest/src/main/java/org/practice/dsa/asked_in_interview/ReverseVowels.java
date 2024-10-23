package org.practice.dsa.asked_in_interview;

public class ReverseVowels {
    /*
    * To reverse only the vowels in a given string
    * When input IceCreAm then output should be AceCrelm*/

    public static void main(String[] args) {
        String s = "IceCreAm";
        String actual = reverseVowels(s);
        System.out.println(actual);
    }

    public static String reverseVowels(String input) {
        char[] chars = input.toCharArray();

        int left = 0;
        int right = chars.length -1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
