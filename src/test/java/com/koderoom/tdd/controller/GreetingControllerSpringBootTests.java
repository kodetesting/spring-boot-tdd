package com.koderoom.tdd.controller;

import com.koderoom.tdd.model.Employee;
import com.koderoom.tdd.model.Greeting;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerSpringBootTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl;

    @BeforeEach
    void setUpBeforeEach() {
        baseUrl = "http://localhost:" + port;
    }

    @Test
    void loadContext(){}


    @Test
    void test2() {
        String url = baseUrl + "/greeting/v2/?name=raj";
        ResponseEntity responseEntity = this.restTemplate.getForEntity(url, Greeting.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody())
                    .isNotNull()
                    .hasFieldOrPropertyWithValue("name", "raj");
    }

    @Test
    void test3() {
        String url = baseUrl + "/greeting/";
        Greeting greeting = new Greeting(1,"raj", "namaste");
        ResponseEntity responseEntity = this.restTemplate.postForEntity(url, greeting, Greeting.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody())
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 1)
                .usingRecursiveComparison()
                .isEqualTo(greeting)
        ;
    }

}