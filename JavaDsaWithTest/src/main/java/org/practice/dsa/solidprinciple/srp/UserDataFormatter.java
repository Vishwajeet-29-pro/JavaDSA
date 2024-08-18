package org.practice.dsa.solidprinciple.srp;

public class UserDataFormatter {

    public String formatData(UserData userData) {
        return "User: "+userData.getName() +" is "+userData.getAge() +" years old";
    }
}
