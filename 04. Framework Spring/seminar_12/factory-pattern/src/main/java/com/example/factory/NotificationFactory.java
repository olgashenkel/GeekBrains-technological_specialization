package com.example.factory;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    public NotificationService createNotification(String type) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            return new EmailNotificationService();
        } else if ("SMS".equalsIgnoreCase(type)) {
            return new SmsNotificationService();
        }
        throw new IllegalArgumentException("Unknown notification type");
    }
}