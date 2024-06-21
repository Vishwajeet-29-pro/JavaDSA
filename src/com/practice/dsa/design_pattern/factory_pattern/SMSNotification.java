package com.practice.dsa.design_pattern.factory_pattern;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("SMS Notification sent !!");
    }
}
