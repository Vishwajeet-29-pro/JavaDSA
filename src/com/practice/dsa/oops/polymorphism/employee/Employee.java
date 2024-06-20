package com.practice.dsa.oops.polymorphism.employee;

abstract class Employee {
    private String name;
    private String employeeId;

    public Employee(String name, String employeeId){
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract void calculatePay();

    public void display(){
        System.out.println("The Name of the Employee: "+name);
        System.out.println("The Employee Id is: "+employeeId);
    }
}
