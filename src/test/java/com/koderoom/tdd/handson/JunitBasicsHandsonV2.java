package com.koderoom.tdd.handson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
@DisplayName("Junit Handson")
public class JunitBasicsHandsonV2 {

    @Test
    @DisplayName("Assert All")
    void test1() {
        Assertions.assertEquals(5, 5);
        Assertions.assertEquals(5, 5, "Expected 5");
        Assertions.assertEquals(5, 5, () -> "Expected 5");
    }
}
