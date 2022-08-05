package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Environment env;

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

    @PostMapping("/v1")
    public ResponseEntity<?> postEmployee(@RequestBody  Employee employee) {
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }
}
