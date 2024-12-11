package org.practice.dsa.simple;

/**
* An Armstrong number (or Narcissistic number) is a number that is equal to the sum of its own digits, each raised to the power of the number of digits.
* Example
 * 153: 1^3 + 5^3 + 3^3 = 1+125+27=153 → Armstrong number.
 * */
public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmStrongNumber(153));
        System.out.println(isArmStrongNumber(9474));
        System.out.println(isArmStrongNumber(944));
    }

    public static boolean isArmStrongNumber(int number) {
        int originalNumber = number;
        int digitCount = power(number);
        int result = 0;
        while (number > 0) {
            int remainder = number % 10;
            result = (int) (result + Math.pow(remainder, digitCount));
            number/=10;
        }
        return result == originalNumber;
    }

    private static int power(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number/=10;
        }
        return count;
    }
}
