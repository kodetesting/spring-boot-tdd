package com.koderoom.tdd.controller;

import com.koderoom.tdd.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@WebMvcTest
class GreetingControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingService greetingService;

    @Test
    @DisplayName("Testing GET /greeting/")
    void testGreetingV1() throws Exception {
        Mockito.when(greetingService.greetingV1("raj")).thenReturn("Namaste, raj");

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greeting/?name=raj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Namaste")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
        ;
    }
}