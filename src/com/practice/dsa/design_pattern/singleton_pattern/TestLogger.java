package com.practice.dsa.design_pattern.singleton_pattern;

public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println(logger1 == logger2);

        logger1.log("This is first log from logger1 Object");
        logger2.log("This is second log from logger2 Object");
    }
}
