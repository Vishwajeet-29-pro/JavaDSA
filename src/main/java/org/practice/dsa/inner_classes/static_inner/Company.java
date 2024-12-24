package org.practice.dsa.inner_classes.static_inner;

public class Company {
    private static String companyName = "Vishwa Tech-Hub pvt. Ltd.";
    private static String companyAddress = "Kolhar Bk.";
    private String nonStaticMember = "Non static member";

    static class Employee {
        private String employeeName;
        private String employeeId;

        public Employee(String employeeName, String employeeId) {
            this.employeeName = employeeName;
            this.employeeId = employeeId;
        }

        public void displayCompanyData() {
            System.out.println("Company Name: "+companyName);
            System.out.println("Company Address: "+companyAddress);
            // not able to access the non-static members.
//            System.out.println("non Static member: "+nonStaticMember);
            System.out.println("Employee name: "+employeeName);
            System.out.println("Employee id: "+employeeId);
        }
    }

    public static void main(String[] args) {
        Company.Employee employeeOne = new Company.Employee("John Wick","101");
        Company.Employee employeeTwo = new Company.Employee("Jack Sparrow","102");

        employeeOne.displayCompanyData();
        System.out.println();
        employeeTwo.displayCompanyData();
    }
}
