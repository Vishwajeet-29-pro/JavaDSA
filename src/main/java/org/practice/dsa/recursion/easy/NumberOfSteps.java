package org.practice.dsa.recursion.easy;

public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps(int num) {

        if (num == 0) {
            return 0;
        }
        if (num % 2 == 0) {
          return 1 + numberOfSteps(num/2);
        } else {
         return 1 + numberOfSteps(num - 1);
        }
    }
}
