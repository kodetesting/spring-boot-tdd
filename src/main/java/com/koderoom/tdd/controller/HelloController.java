package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/v2/{id}")
    public ResponseEntity<?> sayHelloV2(@RequestParam("name") String name, @PathVariable String id) {
        return new ResponseEntity<>("Hello " + name + " " + id, HttpStatus.OK);
    }

    @GetMapping("/v2/{p1}/{p2}")
    public ResponseEntity<?> sayHelloV3(@RequestParam("name") String name, @PathVariable String p1, @PathVariable String p2) {
        return new ResponseEntity<>("Hello " + name + " " + p1 + p2, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> postHello() {
        return new ResponseEntity<>("Hello Post!" , HttpStatus.CREATED);
    }

    @PostMapping("/v1")
    public ResponseEntity<?> postEmployee(@RequestBody  Employee employee) {
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }

    @PostMapping("/v2/{id}")
    public ResponseEntity<?> postEmployee2(@RequestBody  Employee employee, @PathVariable String id) {
        employee.setUid(id);
        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }
}
