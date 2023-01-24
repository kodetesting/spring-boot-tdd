package com.koderoom.tdd.trash;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello() {
        return "Hello World";
    }
}
