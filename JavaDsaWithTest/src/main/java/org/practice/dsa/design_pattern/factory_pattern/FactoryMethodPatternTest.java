package org.practice.dsa.design_pattern.factory_pattern;

/*
* This implementation of the Factory Method pattern decouples the client code from the specific classes of the objects
* it needs to create. Instead of instantiating the objects directly, the client code calls the factory method, which
* returns the appropriate object based on the input. This makes the code more flexible and easier to maintain.
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
