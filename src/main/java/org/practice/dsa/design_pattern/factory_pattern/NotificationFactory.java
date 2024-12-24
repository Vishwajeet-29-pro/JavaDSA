package org.practice.dsa.design_pattern.factory_pattern;

public class NotificationFactory {
    public Notification createNotification(String type){
        if (type == null || type.isEmpty())
            return null;
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown Notification type:" + type);
        };
        }
    }

