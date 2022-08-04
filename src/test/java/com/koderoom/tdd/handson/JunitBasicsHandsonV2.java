package com.koderoom.tdd.handson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class JunitBasicsHandsonV2 {

    @Test
    @DisplayName("Assert All")
    void test1() {
        Assertions.assertEquals(5, 5);
        Assertions.assertEquals(5, 5, "Expected 5");
        Assertions.assertEquals(5, 5, () -> "Expected 5");
    }
}
