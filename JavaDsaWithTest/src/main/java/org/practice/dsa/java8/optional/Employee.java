package org.practice.dsa.java8.optional;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Employee {
    private final String name;
    private final String email;
    private final Optional<String> phoneNumber;
    private final Optional<String> department;

    public Employee(String name, String email, Optional<String> phoneNumber, Optional<String> department) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public Optional<String> getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", department=" + department +
                '}';
    }
}
