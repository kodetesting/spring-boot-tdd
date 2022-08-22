package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.User;
import com.koderoom.tdd.service.UserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class UserControllerSpringBootTestsUsingMockMvc {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Testing sayHi from User Controller")
    void test1() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/hi"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")))
        ;
    }


    @Test
    @DisplayName("Testing Find All Record")
    void test2() throws Exception{
        List<User> list = new ArrayList<>();
        User user1 = new User("1", UUID.randomUUID(), "raj", "sharma", "raj@raj.com", "112", LocalDateTime.now());
        list.add(user1);

        Mockito.when(userService.findAll("test")).thenReturn(list);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/?entityUid=test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].firstName", Matchers.is("raj")))
        ;
    }

}