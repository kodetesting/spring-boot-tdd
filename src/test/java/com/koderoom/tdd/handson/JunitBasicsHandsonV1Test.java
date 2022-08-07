package com.koderoom.tdd.handson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
@DisplayName("JunitBasicsHandsonV1")
class JunitBasicsHandsonV1Test {

    @Test
    @DisplayName("True Assertions")
    void test3() {
        Assertions.assertTrue(true);
        Assertions.assertTrue(true, "Expected True");
        Assertions.assertTrue(true, () -> "Expected true");
    }

    @Test
    @DisplayName("False Assertions")
    void test4() {
        Assertions.assertFalse(false);
        Assertions.assertFalse(false, "Expected false");
        Assertions.assertFalse(false, () -> "Expected false");
    }

    @Test
    @DisplayName("Null Assertions")
    void test5() {
        Assertions.assertNull(null);
        Assertions.assertNull(null, "Expected null");
        Assertions.assertNull(null, () -> "Expected null");
    }

    @Test
    @DisplayName("Not Null Assertions")
    void test6() {
        // Assertions.assertNotNull(5);
        // Assertions.assertNotNull(5, "Expected Not null");
        // Assertions.assertNotNull(5, () -> "Expected Not null");
        boolean actual = true;
        org.assertj.core.api.Assertions.assertThat(actual).isTrue();
    }


    @Test
    @DisplayName("Assert Throws")
    void test7() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("message");
        });

        Assertions.assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("message");
        }, "Expected Null Pointer Exception");

        Assertions.assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("message");
        }, () -> "Expected Null Pointer Exception");
    }


    @Test
    @DisplayName("Assert does not throw")
    void test8() {
        Assertions.assertDoesNotThrow(() -> "hello", "Expected will not throw expection");
        Assertions.assertDoesNotThrow(() -> "hello", () -> "Expected will not throw expection");
    }


    @Test
    @DisplayName("Timeout Check")
    void test9() {
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> System.out.println("code block"));
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> System.out.println("code block"), "Excepted to complete in 1 sec");
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> System.out.println("code block"), () -> "Excepted to complete in 1 sec");
    }


    @Test
    @DisplayName("Equals Check")
    void test1() {
        int actual = 5;
        Assertions.assertEquals(5, actual);
        Assertions.assertEquals(5, actual, "Expected 5");
        Assertions.assertEquals(5, actual, () -> "Expected 5");
    }

    @Test
    @DisplayName("Unexpected check")
    void test2() {
        int actual = 10;
        Assertions.assertNotEquals(5, actual);
        Assertions.assertNotEquals(5, actual, "UnExpected 5");
        Assertions.assertNotEquals(5, actual, () -> "Unexpected 5");
    }

}
