package com.pkucharek.greeter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Greeter {
    private final BeginningProvider beginningProvider;

    public Greeter(BeginningProvider beginningProvider) {
        this.beginningProvider = beginningProvider;
    }

    public String greet(String name) {
        String beginning = beginningProvider.provide();
        String correctedName = getCorrectedName(name);

        String result = String.format("%s %s", beginning, correctedName);
        print(result);

        return result;
    }

    private void print(String result) {
        System.out.println(result);
    }

    private String getCorrectedName(String name) {
        String trimmedName = name.trim();
        return StringUtils.capitalize(trimmedName);
    }
}
