package com.example.monitoring.controller;

import com.example.monitoring.service.GreetingService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final GreetingService greetingService;
    private final Counter helloCounter;

    public DemoController(GreetingService greetingService, MeterRegistry meterRegistry) {
        this.greetingService = greetingService;
        this.helloCounter = meterRegistry.counter("custom_hello_requests_total");
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        helloCounter.increment();
        return greetingService.greet(name);
    }
}
