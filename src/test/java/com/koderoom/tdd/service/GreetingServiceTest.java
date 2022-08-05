package com.koderoom.tdd.service;

import com.koderoom.tdd.model.Greeting;
import com.koderoom.tdd.repository.GreetingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @InjectMocks
    GreetingService greetingService;

    @Mock
    GreetingRepository greetingRepository;

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

    @Test
    void tsetGreetingV3() {
        List<Greeting> list = new ArrayList<>();
        Greeting greeting1 = new Greeting(1, "raj", "namaste");
        list.add(greeting1);
        Greeting greeting2 = new Greeting(2, "rohit", "namaste");
        list.add(greeting2);

        Mockito.when(greetingRepository.findAll()).thenReturn(list);

        Assertions.assertThat(greetingService.greetingV3())
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .first().hasFieldOrPropertyWithValue("name", "raj")
        ;
    }

    @Test
    void testGreetingV4() {
        Greeting greeting = new Greeting(1, "raj", "namaste");
        Mockito.when(greetingRepository.save(greeting)).thenReturn(greeting);

        Assertions.assertThat(greetingService.greetingV4(greeting))
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", "raj")
        ;
    }

}