package com.practice.dsa.design_pattern.factory_pattern;

/*
* This implementation of the Observer pattern allows multiple investors to be notified whenever there is a change in the
* stock price, without tightly coupling the stock to the investors. The stock (subject) maintains a list of investors
* (observers) and notifies them whenever its state changes.
* */

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
