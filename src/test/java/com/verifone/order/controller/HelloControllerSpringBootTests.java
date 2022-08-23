package com.verifone.order.controller;

import com.verifone.order.model.Employee;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerSpringBootTests {

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
        String url = baseUrl + "/hello/";
        String actual = this.restTemplate.getForObject(url, String.class);
        Assertions.assertThat(actual).isNotNull().isEqualTo("Hello World!");
    }

    @Test
    void test2() {
        String url = baseUrl + "/hello/";
        ResponseEntity responseEntity = this.restTemplate.getForEntity(url, String.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody())
                    .isNotNull()
                    .isEqualTo("Hello World!");
    }

    @Test
    void test3() {
        String url = baseUrl + "/hello/v1";
        Employee employee = new Employee(1,"raj", "101");
        ResponseEntity responseEntity = this.restTemplate.postForEntity(url, employee, Employee.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody())
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 1)
                .usingRecursiveComparison()
                .isEqualTo(employee)
        ;
    }

}