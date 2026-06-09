package com.example.factory;

import org.springframework.stereotype.Component;

@Component
public class ExampleUsage {

    private final NotificationFactory factory;

    public ExampleUsage(NotificationFactory factory) {
        this.factory = factory;
        performTask();
    }

    public void performTask() {
        NotificationService service = factory.createNotification("EMAIL");
        service.send("Factory pattern in action!");
    }
}