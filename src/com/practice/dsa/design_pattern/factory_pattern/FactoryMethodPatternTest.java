package com.practice.dsa.design_pattern.factory_pattern;

public class FactoryMethodPatternTest {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Notification emailNotification = notificationFactory.createNotification("email");
        emailNotification.notifyUser();

        Notification smsNotification = notificationFactory.createNotification("sms");
        smsNotification.notifyUser();

        Notification pushNotification = notificationFactory.createNotification("push");
        pushNotification.notifyUser();
    }
}
