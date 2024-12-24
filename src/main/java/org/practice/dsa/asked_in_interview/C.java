package org.practice.dsa.asked_in_interview;

import java.util.UUID;

public class C extends B{
    @Override
    public void printMethod() {
        super.printMethod();
        System.out.println("C");
    }

    public static void main(String[] args) {
        C c = new C();
        c.printMethod();
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
