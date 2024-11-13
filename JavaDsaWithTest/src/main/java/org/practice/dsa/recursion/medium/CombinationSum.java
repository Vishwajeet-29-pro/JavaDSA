package org.practice.dsa.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));  // Add a copy of the path to the result
            return;
        }
        
        // Iterate over candidates starting from 'start' to avoid duplicate combinations
        for (int i = start; i < candidates.length; i++) {
            int current = candidates[i];
            
            // If current candidate is greater than target, skip it (since candidates are distinct integers)
            if (current > target) continue;

            // Choose the current candidate and add it to the path
            path.add(current);

            // Recursively call with updated target and the same start index (to reuse the candidate)
            backtrack(candidates, target - current, i, path, result);

            // Backtrack: remove the last element added to explore other combinations
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println("Combinations that sum to target: " + combinationSum(candidates, target));
    }
}
