package com.practice.dsa.oops.employee;

public class FullTimeEmployees extends Employee{

    private double annualSalary;

    public FullTimeEmployees(String name, String employeeId, double annualSalary) {
        super(name, employeeId);
        this.annualSalary = annualSalary;
    }

    @Override
    public void calculatePay() {
        double monthlyPay = annualSalary / 12;
        System.out.println("The Monthly Pay for FullTime Employee is: "+monthlyPay);
    }

}
