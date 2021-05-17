package com.pkucharek.greeter;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
class BeginningProviderImpl implements BeginningProvider {
    private final TimeProvider timeProvider;
    private final List<TimeRangePredicateSupplier> timeRanges;

    BeginningProviderImpl(TimeProvider timeProvider, List<TimeRangePredicateSupplier> predicates) {
        this.timeProvider = timeProvider;
        this.timeRanges = predicates;
    }

    @Override
    public String provide() {
        LocalTime time = timeProvider.provide();
        return timeRanges.stream().filter(p -> p.test(time)).findFirst().map(TimeRangePredicateSupplier::get).orElseThrow(() -> new RuntimeException("Invalid time"));
    }
}
