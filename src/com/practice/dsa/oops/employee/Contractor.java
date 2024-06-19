package com.practice.dsa.oops.employee;

public class Contractor extends Employee {
    private double contractAmount;

    public Contractor(String name, String employeeId, double contractAmount){
        super(name, employeeId);
        this.contractAmount = contractAmount;
    }

    @Override
    public void calculatePay() {
        System.out.println("The contract Amount is: "+contractAmount);
    }
}
