package com.pkucharek.greeter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

interface TimeRangePredicateSupplier {
    boolean test(LocalTime time);
    String get();
}
