package com.example.decorator;

import org.springframework.stereotype.Component;

@Component
public class ExampleUsage {

    private final EncryptedDataProcessor encryptedProcessor;

    public ExampleUsage(EncryptedDataProcessor encryptedProcessor) {
        this.encryptedProcessor = encryptedProcessor;
        performTask();
    }

    public void performTask() {
        String result = encryptedProcessor.process("Decorator pattern in action!");
        System.out.println(result);
    }
}