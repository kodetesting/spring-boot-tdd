package com.koderoom.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koderoom.tdd.model.Employee;
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
    @DisplayName("Path Param Testing")
    void getPathparamTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/v2/{id}?name=raj", "101"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("101")))
        ;
    }

    @Test
    @DisplayName("Path Param Testing")
    void getPathparamTest2() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello/v2/{p1}/{p2}?name=raj", "101", "202"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("101")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("202")))
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


    @Test
    @DisplayName("Post Mapping with Request Body")
    void postTest2() throws Exception {
        Employee employee = new Employee(1, "raj", "101");
        ObjectMapper objectMapper = new ObjectMapper();

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/hello/")
                        .content(objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
        ;
    }


    @Test
    @DisplayName("Post Mapping with Request Body")
    void postTest3() throws Exception {
        Employee employee = new Employee(1, "raj", null);
        ObjectMapper objectMapper = new ObjectMapper();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/hello/v1")
                                .content(objectMapper.writeValueAsString(employee))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.containsString("raj")))
        ;
    }


    @Test
    @DisplayName("Post Mapping with Request Body")
    void postTestWithPathParam() throws Exception {
        Employee employee = new Employee(1, "raj", "101");
        ObjectMapper objectMapper = new ObjectMapper();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/hello/v2/{id}", "202")
                                .content(objectMapper.writeValueAsString(employee))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.containsString("raj")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.uid", Matchers.containsString("202")))
        ;
    }
}