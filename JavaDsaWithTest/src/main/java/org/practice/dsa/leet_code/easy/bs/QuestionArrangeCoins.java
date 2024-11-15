package org.practice.dsa.leet_code.easy.bs;

public class QuestionArrangeCoins {
//     You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the
//     ith row has exactly i coins. The last row of the staircase may be incomplete.
//    Given the integer n, return the number of complete rows of the staircase you will build.
//
//     Input: n = 5
//    Output: 2
//    Explanation: Because the 3rd row is incomplete, we return 2.

    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long coinUsed = (long) mid * (mid + 1)/2;
            
            if (coinUsed == n) {
                return mid;
            } else if (coinUsed <= n) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return end;
    }
}
