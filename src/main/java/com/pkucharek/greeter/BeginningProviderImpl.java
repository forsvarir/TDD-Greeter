package com.pkucharek.greeter;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
class BeginningProviderImpl implements BeginningProvider {
    private final TimeProvider timeProvider;
    private final List<TimeBasedGreetingSupplier> timeRanges;

    BeginningProviderImpl(TimeProvider timeProvider, List<TimeBasedGreetingSupplier> predicates) {
        this.timeProvider = timeProvider;
        this.timeRanges = predicates;
    }

    @Override
    public String provide() {
        LocalTime time = timeProvider.provide();
        return timeRanges.stream().filter(p -> p.test(time)).findFirst().map(TimeBasedGreetingSupplier::get).orElseThrow(() -> new RuntimeException("Invalid time"));
    }
}
