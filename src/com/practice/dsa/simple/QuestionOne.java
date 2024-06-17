package com.practice.dsa.simple;

import java.util.Scanner;

public class QuestionOne {
    public static void main(String[] args) {
        var input = acceptInput();
        var result = validateNumberIsOddOrEven(input);
        printResult(input, result);
    }

    static int acceptInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number");
        return scanner.nextInt();
    }

    static void printResult(int number, boolean result){
        if (result){
            System.out.println("The number "+number+" is Even");
        } else System.out.println("The number "+number+" is Odd");
    }

    static boolean validateNumberIsOddOrEven(int number){
        return number % 2 == 0;
    }
}
