package com.savadanko;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final Counter greetingCounter;

    public GreetingController(MeterRegistry registry) {
        this.greetingCounter = registry.counter("greetings.total");
    }

    @GetMapping("/greet")
    public String greet() {
        greetingCounter.increment();
        return "Hello, World!";
    }
}

