package com.example.singleton;

import org.springframework.stereotype.Component;

@Component
public class ExampleUsage {

    private final LoggingService loggingService;

    public ExampleUsage(LoggingService loggingService) {
        this.loggingService = loggingService;
        performTask();
    }

    public void performTask() {
        loggingService.log("Singleton pattern in action!");
    }
}