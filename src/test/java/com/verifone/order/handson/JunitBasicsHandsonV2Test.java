package com.verifone.order.handson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("JunitBasicsHandsonV2")
public class JunitBasicsHandsonV2Test {

    @Test
    @DisplayName("Assert All")
    void test1() {
        Assertions.assertAll("Multiple Assertions",
                () -> Assertions.assertTrue(true),
                () -> Assertions.assertFalse(false),
                () -> Assertions.assertEquals(5+2, 7)
        );
    }


    @Nested
    @DisplayName("Nested Tests")
    class NextedTest1{
        @Test
        @DisplayName("Nested Test1")
        void test1() {
            Assertions.assertTrue(true);
        }

        @Test
        @DisplayName("Nested Test2")
        void test2() {
            Assertions.assertFalse(false);
        }
    }
}
