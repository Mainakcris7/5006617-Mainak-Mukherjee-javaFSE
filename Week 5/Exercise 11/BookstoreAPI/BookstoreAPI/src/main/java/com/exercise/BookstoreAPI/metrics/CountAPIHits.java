package com.exercise.BookstoreAPI.metrics;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

// Go to => http://localhost:8080/admin/metrics/books_api_hit_count to access
@Component
public class CountAPIHits {
    private Counter hitCounter;

    public CountAPIHits(MeterRegistry registry) {
        this.hitCounter = registry.counter("books_api_hit_count", "type", "api_hit_count");
    }

    public void incrementCounter() {
        this.hitCounter.increment();
    }
}
