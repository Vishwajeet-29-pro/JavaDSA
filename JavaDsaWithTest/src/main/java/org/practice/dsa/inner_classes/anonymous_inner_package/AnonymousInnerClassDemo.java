package org.practice.dsa.inner_classes.anonymous_inner_package;

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        Greetings greetings = new Greetings() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World");
            }
        };

        greetings.sayHello();
    }
}
