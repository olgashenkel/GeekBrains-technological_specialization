package com.example.decorator;

import org.springframework.stereotype.Component;

@Component
public class BasicDataProcessor implements DataProcessor {
    @Override
    public String process(String data) {
        return data.toUpperCase();
    }
}