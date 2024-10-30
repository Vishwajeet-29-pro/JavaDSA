package org.practice.dsa.recursion.interview;

import java.util.ArrayList;

public class DiceProblem {
    public static void main(String[] args) {
        dice("", 3);
        System.out.println(diceList("", 2));
        System.out.println();
        customDice("", 7, 7);
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p+i, target - i);
        }
    }

    static ArrayList<String> diceList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <=6 && i <= target; i++) {
            ans.addAll(diceList(p + i, target - i));
        }
        return ans;
    }

    static void customDice(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=face && i<=target ; i++) {
            customDice(p+i, target - i, face);
        }
    }
}
