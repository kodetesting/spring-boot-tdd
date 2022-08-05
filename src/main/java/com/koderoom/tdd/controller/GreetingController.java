package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.Greeting;
import com.koderoom.tdd.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping("/")
    public ResponseEntity<?> greetingV1(@RequestParam String name) {
        String message = greetingService.greetingV1(name);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/v2")
    public ResponseEntity<?> greetingV2(@RequestParam String name) {
        Greeting greeting = greetingService.greetingV2(name);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
