package org.practice.dsa.cucumber_test.some_fake_services;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> users = new HashMap<>();

    public String register(String username, String password) {
        if (users.containsKey(username)) {
            return "Username already exists";
        }
        users.put(username, password);
        return "Registration successful";
    }

    public String login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "Dashboard";
        }
        return "Invalid username or password";
    }
}
