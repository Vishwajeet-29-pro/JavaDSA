package com.practice.dsa.design_pattern.proxy_pattern;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("proxy_image.jpg");

        image.display();
        System.out.println("");

        image.display();
    }
}
