package com.koderoom.tdd.service;

import com.koderoom.tdd.model.Greeting;
import com.koderoom.tdd.repository.GreetingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;

    public String greetingV1(String name) {
        return "Namaste, " + name;
    }

    public Greeting greetingV2(String name) {
        Greeting greeting = new Greeting(1, name, "namaste");
        return greeting;
    }

    public List<Greeting> greetingV3() {
        /*List<Greeting> list = new ArrayList<>();
        Greeting greeting1 = new Greeting(1, "raj", "namaste");
        list.add(greeting1);
        Greeting greeting2 = new Greeting(2, "rohit", "namaste");
        list.add(greeting2);
        return list;*/
        return greetingRepository.findAll();
    }


    public Greeting greetingV4(Greeting greeting) {
        greetingRepository.save(greeting);
        return greeting;
    }

}
