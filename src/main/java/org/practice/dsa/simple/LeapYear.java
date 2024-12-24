package org.practice.dsa.simple;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2008));
    }

    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year % 4 == 0) {
            isLeap = true;
            if (year % 100 == 0) {
                isLeap = year % 400 == 0;
            }
        }
        return isLeap;
    }
}
