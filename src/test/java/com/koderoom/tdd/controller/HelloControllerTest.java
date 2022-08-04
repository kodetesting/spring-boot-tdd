package com.koderoom.tdd.controller;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Testing sayHi from Hello Controller")
    void test1() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")))
        ;
    }


    @Test
    @DisplayName("Testing Second API from Hello Controller")
    void test2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/v1?name=raj"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
        ;
    }


    @Test
    @DisplayName("Post Mapping Testing")
    void postTest1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Hello Post!"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")))
        ;
    }
}