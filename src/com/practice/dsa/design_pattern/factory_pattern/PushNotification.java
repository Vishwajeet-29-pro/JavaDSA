package com.practice.dsa.design_pattern.factory_pattern;

public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Push Notification sent !!");
    }
}
