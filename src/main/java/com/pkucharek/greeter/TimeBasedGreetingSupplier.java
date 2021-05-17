package com.pkucharek.greeter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

interface TimeBasedGreetingSupplier {
    boolean test(LocalTime time);

    String get();
}
