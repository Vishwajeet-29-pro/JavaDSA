package org.practice.dsa.recursion.subset;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
//        subSequence("","abc");
//        System.out.println(subSequenceReturn("","abc"));
//        subSequenceWithAscii("","abc");
        System.out.println(subSequenceAsciiReturn("","abc"));;
    }


    public static void subSequence(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequence(p+ch, up.substring(1));
        subSequence(p, up.substring(1));
    }

    public static ArrayList<String> subSequenceReturn(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String>  left = subSequenceReturn(ch + p, up.substring(1));
        ArrayList<String> right = subSequenceReturn(p, up.substring(1));
        left.addAll(right);

        return left;
    }

    public static void subSequenceWithAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSequenceWithAscii(ch + p, up.substring(1));
        subSequenceWithAscii(p, up.substring(1));
        subSequenceWithAscii(p + (ch+0),up.substring(1));
    }

    public static ArrayList<String> subSequenceAsciiReturn(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String>  first = subSequenceReturn(ch + p, up.substring(1));
        ArrayList<String> second = subSequenceReturn(p, up.substring(1));
        ArrayList<String> third = subSequenceAsciiReturn(p + (ch+0), up.substring(1));
        first.addAll(second);
        first.addAll(third);

        return first;
    }
}
