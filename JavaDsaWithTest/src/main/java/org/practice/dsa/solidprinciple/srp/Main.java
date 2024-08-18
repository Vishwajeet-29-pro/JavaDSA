package org.practice.dsa.solidprinciple.srp;

public class Main {
    public static void main(String[] args) {
        UserData userData = new UserData("Vishwajeet",24);

        UserPersistence persistence = new UserPersistence();
        UserDataFormatter formatter = new UserDataFormatter();

        try {
            persistence.saveToFile(userData, "userdata.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(formatter.formatData(userData));
    }
}
