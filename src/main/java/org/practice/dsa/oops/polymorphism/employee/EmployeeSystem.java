package org.practice.dsa.oops.polymorphism.employee;

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee fullTimeEmployees = new FullTimeEmployees("Vishwajeet","0001",2000000);
        Employee partTimeEmployees = new PartTimeEmployee("Anil","0010",200, 50);
        Employee contractor = new Contractor("Shambu","0100",2000000);

        System.out.println("Full Time Employees Details: ");
        fullTimeEmployees.display();
        fullTimeEmployees.calculatePay();
        System.out.println();

        System.out.println("Part Time Employees Details: ");
        partTimeEmployees.display();
        partTimeEmployees.calculatePay();
        System.out.println();

        System.out.println("Contract Type Employees Details: ");
        contractor.display();
        contractor.calculatePay();
        System.out.println();
    }
}
