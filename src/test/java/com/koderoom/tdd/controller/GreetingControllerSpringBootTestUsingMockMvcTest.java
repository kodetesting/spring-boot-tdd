package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.Greeting;
import com.koderoom.tdd.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerSpringBootTestUsingMockMvcTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingService greetingService;

    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
    }

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


    @Test
    @DisplayName("Testing GET /greeting/v2")
    void testGreetingV2() throws Exception {
        Greeting greeting = new Greeting(1, "raj", "namaste");
        Mockito.when(greetingService.greetingV2("raj")).thenReturn(greeting);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greeting/v2?name=raj"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("namaste")))
        ;
    }



    @Test
    @DisplayName("Testing GET /greeting/v3")
    void testGreetingV3() throws Exception {
        List<Greeting> list = new ArrayList<>();
        Greeting greeting = new Greeting(1, "raj", "namaste");
        list.add(greeting);

        Mockito.when(greetingService.greetingV3()).thenReturn(list);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/greeting/v3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].message", Matchers.is("namaste")))
        ;
    }



    @Test
    @DisplayName("Testing POST /greeting")
    void testGreetingV4() throws Exception {
        Greeting greeting = new Greeting(1, "raj", "namaste");

        Mockito.when(greetingService.greetingV4(greeting)).thenReturn(greeting);

        this.mockMvc.perform(MockMvcRequestBuilders
                            .post("/greeting/")
                            .content(objectMapper.writeValueAsString(greeting))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("namaste")))
        ;
    }
}