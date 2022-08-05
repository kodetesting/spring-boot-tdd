package com.koderoom.tdd.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {

    public String greetingV1(String name) {
        return "Namaste, " + name;
    }

}
