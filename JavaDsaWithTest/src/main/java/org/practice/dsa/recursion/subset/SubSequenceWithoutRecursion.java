package org.practice.dsa.recursion.subset;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceWithoutRecursion {
    public static void main(String[] args) {
        var ans = subset(new int[] {1,2,3});
        for (var a: ans) {
            System.out.println(a);
        }
//        subset(new int[] {1,2,3}).forEach(System.out::println);
    }

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num: arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
