package com.koderoom.tdd.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @InjectMocks
    GreetingService greetingService;

    @Test
    void testGreetingV1() {
        String message = greetingService.greetingV1("raj");
        Assertions.assertThat(message)
                .isNotNull()
                .isNotEmpty()
                .contains("Namaste")
                .contains("raj")
                .startsWith("Namaste")
                .endsWith("raj")
        ;
    }

}