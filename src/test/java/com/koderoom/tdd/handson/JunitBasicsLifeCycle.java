package com.koderoom.tdd.handson;

import org.junit.jupiter.api.*;

@DisplayName("Life Cycle Demo")
public class JunitBasicsLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all the test case execution");
    }

    @BeforeEach
    void setup() {
        System.out.println("Before Each Test ");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each Test");
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
