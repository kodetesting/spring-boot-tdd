package com.koderoom.tdd.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AutoConfigureDataMongo
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerSpringBootTests {

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
    void test1() {
        String url = baseUrl + "/user/hi";
        String actual = this.restTemplate.getForObject(url, String.class);
        Assertions.assertThat(actual).isNotNull().isEqualTo("Hello World!");
    }

    @Test
    void test2() {
        String url = baseUrl + "/user/?entityUid=test";
        ResponseEntity responseEntity = this.restTemplate.getForEntity(url, List.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}