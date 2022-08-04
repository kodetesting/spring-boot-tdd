package com.koderoom.tdd.handson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitBasicsHandsonV1 {

    @Test
    @DisplayName("Equals Check")
    void test1() {
        Assertions.assertEquals(5, 5);
        Assertions.assertEquals(5, 5, "Expected 5");
        Assertions.assertEquals(5, 5, () -> "Expected 5");
    }

    @Test
    @DisplayName("Unexpected check")
    void test2() {
        Assertions.assertNotEquals(5, 10);
        Assertions.assertNotEquals(5, 10, "UnExpected 5");
        Assertions.assertNotEquals(5, 10, () -> "Unexpected 5");
    }

    @Test
    @DisplayName("Boolean Assertions")
    void test3() {
        Assertions.assertTrue(true);
        Assertions.assertTrue(true, "Expected True");
        Assertions.assertTrue(true, () -> "Expected true");

        Assertions.assertFalse(false);
        Assertions.assertFalse(false, "Expected false");
        Assertions.assertFalse(false, () -> "Expected false");
    }
}
