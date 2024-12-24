package org.practice.dsa.design_pattern.factory_pattern;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Email Notification sent !!");
    }
}
