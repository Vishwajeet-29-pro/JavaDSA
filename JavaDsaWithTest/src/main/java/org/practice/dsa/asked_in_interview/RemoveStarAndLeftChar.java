package org.practice.dsa.asked_in_interview;

public class RemoveStarAndLeftChar {
    /*
     We have given a string in which some characters are *, we need to remove the left most character from *
     for each occurrence of * and then * too.
    * */
    public static void main(String[] args) {
        // Test the function
        String input = "Switz**la*d";
        String result = removeStarAndLeftChar(input);

        // Expected output: "Swild"
        System.out.println("Result: " + result);
    }
    public static String removeStarAndLeftChar(String str) {
        if(str.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder(str);

        int i =0;
        while (i < builder.length()) {

            if (builder.charAt(i) == '*') {
                if (i - 1 >= 0) {
                    builder.deleteCharAt(i - 1);
                    i--;
                }
                while (i < builder.length() && builder.charAt(i) == '*') {
                    builder.deleteCharAt(i);
                }
                i--;
            }
            i++;
        }
        return builder.toString();
    }
}
