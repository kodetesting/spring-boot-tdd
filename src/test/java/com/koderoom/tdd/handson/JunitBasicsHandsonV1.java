package com.koderoom.tdd.handson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitBasicsHandsonV1 {

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
        Assertions.assertNotNull(null);
        Assertions.assertNotNull(null, "Expected Not null");
        Assertions.assertNotNull(null, () -> "Expected Not null");
    }


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
}
