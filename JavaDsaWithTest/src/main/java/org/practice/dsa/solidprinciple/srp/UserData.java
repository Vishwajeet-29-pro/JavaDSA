package org.practice.dsa.solidprinciple.srp;

public class UserData {
    private final String name;
    private final int age;

    public UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
