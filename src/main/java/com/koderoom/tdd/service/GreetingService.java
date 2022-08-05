package com.koderoom.tdd.service;

import com.koderoom.tdd.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {

    public String greetingV1(String name) {
        return "Namaste, " + name;
    }

    public Greeting greetingV2(String name) {
        Greeting greeting = new Greeting(1, name, "namaste");
        return greeting;
    }

}
