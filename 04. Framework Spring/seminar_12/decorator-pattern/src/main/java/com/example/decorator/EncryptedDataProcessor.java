package com.example.decorator;

import org.springframework.stereotype.Component;

@Component
public class EncryptedDataProcessor implements DataProcessor {

    private final BasicDataProcessor processor;

    public EncryptedDataProcessor(BasicDataProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String process(String data) {
        String processedData = processor.process(data);
        return "Encrypted(" + processedData + ")";
    }
}