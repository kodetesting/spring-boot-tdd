package com.koderoom.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Hello World!" , HttpStatus.OK);
    }

    @GetMapping("/v1")
    public ResponseEntity<?> sayHelloV1(String name) {
        return new ResponseEntity<>("Hello " + name , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> postHello() {
        return new ResponseEntity<>("Hello Post!" , HttpStatus.CREATED);
    }
}
