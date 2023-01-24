package com.koderoom.tdd.trash;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @InjectMocks
    HelloService helloService;

    @Test
    void test1() {
        String output = helloService.sayHello();
        Assertions.assertThat(output).isNotNull().isNotEmpty().isEqualTo("Hello World");
    }
}