package org.practice.dsa.leet_code.easy;

public class QuestionSquareRoot {
    public int mySqrt(int x) {
        
        int start = 0;
        int end = x;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (((long) mid * mid) == x) {
                return mid;
            } else if (((long)mid * mid) <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
}
