package com.pkucharek.greeter;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
class MorningPredicateSupplier implements TimeRangePredicateSupplier {
    @Override
    public boolean test(LocalTime time) {
        return time.isAfter(LocalTime.parse("06:00:00"))
                && time.isBefore(LocalTime.parse("12:00:01"));
    }

    @Override
    public String get() {
        return "Good morning";
    }
}
