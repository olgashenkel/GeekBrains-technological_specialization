package com.example.monitoring.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomMetricsRegistrar {

    private final MeterRegistry meterRegistry;
    private final AtomicInteger customGaugeValue;

    public CustomMetricsRegistrar(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.customGaugeValue = new AtomicInteger(0);
    }

    @PostConstruct
    public void registerMetrics() {
        Gauge.builder("custom_gauge_metric", customGaugeValue, AtomicInteger::get)
                .register(meterRegistry);
    }

    public void incrementGauge() {
        customGaugeValue.incrementAndGet();
    }

    public void decrementGauge() {
        customGaugeValue.decrementAndGet();
    }
}
