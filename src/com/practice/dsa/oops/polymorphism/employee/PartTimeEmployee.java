package com.practice.dsa.oops.polymorphism.employee;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculatePay() {
        double payment = hourlyRate * hoursWorked;
        System.out.println("The the amount to Pay is: "+payment+" for the "+hoursWorked+" Hours worked");
    }
}
