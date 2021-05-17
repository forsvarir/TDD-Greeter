package com.pkucharek.greeter;

import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

class GreeterControllerTestConfig {

    @Bean
    GreeterController greeterController(Greeter greeter) {
        return new GreeterController(greeter);
    }

    @Bean
    Greeter greeter() {
        return new Greeter(beginningProvider());
    }

    @Bean
    BeginningProvider beginningProvider() {
        List<TimeBasedGreetingSupplier> predicates = Arrays.asList(new AfternoonGreetingSupplier(), new EveningGreetingSupplier(), new NightGreetingSupplier(), new MorningGreetingSupplier());
        return new BeginningProviderImpl(() -> LocalTime.parse("13:00"), predicates);
    }

    @Bean
    TimeProvider timeProvider() {
        return LocalTime::now;
    }
}
