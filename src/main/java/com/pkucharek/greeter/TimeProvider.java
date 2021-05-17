package com.pkucharek.greeter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

interface TimeProvider {
    LocalTime provide();
}

@Service
class DefaultTimeProvider implements TimeProvider {
    @Override
    public LocalTime provide() {
        return LocalTime.now();
    }
}
