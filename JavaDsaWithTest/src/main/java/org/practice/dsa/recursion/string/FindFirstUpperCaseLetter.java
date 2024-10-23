package org.practice.dsa.recursion.string;

public class FindFirstUpperCaseLetter {
    /*
    * Given a string find its first uppercase letter
        Examples :

        Input : geeksforgeeKs
        Output : K

        Input  : geekS
        Output : S
* */
    public char find(String s, int i) {
        if (s.isEmpty()) {
            return 0;
        }

        if (Character.isUpperCase(s.charAt(i))){
            return s.charAt(i);
        }
        return find(s, i+1);
    }
}
