package com.koderoom.tdd.handson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("JunitBasicsLifeCycle")
class JunitBasicsLifeCycleTest {

    @BeforeAll
    static void beforeAll(){
        log.info("Before All");
    }

    @AfterAll
    static void afterAll() {
        log.info("After all the test case execution");
    }

    @BeforeEach
    void setup() {
        log.info("Before Each Test ");
    }

    @AfterEach
    void afterEach() {
        log.info("After Each Test");
    }

    @Test
    @DisplayName("Boolean Assertion")
    void test1() {
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Boolean Assertion")
    void test2() {
        Assertions.assertFalse(false);
    }
}
