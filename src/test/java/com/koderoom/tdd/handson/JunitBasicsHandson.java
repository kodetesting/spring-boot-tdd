package com.koderoom.tdd.handson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitBasicsHandson {

    @Test
    @DisplayName("Boolean Assertion")
    void test1_booleanAssertion() {
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    }

    @Test
    @DisplayName("Boolean Assertions with Message")
    void test2_booleanAssertionWithMessage() {
        Assertions.assertTrue(true, "Msg, Expected True");
        Assertions.assertTrue(false, "Msg, Expected True");

        // Using Supplier
        Assertions.assertTrue(true, () -> "Message, Expected true");
        Assertions.assertTrue(false, () -> "Message, Expected true");
    }

    @Test
    @DisplayName("Boolean Assertion Variations with Supplier")
    void test3_booleanAssertionWithSupplier() {
        Assertions.assertTrue(() -> true);
        Assertions.assertTrue(() -> {
            // ...complex logic
            return true;
        });

        Assertions.assertTrue(() -> true, "This assertion test failed");
        Assertions.assertTrue(() -> false, () -> "Message, Expected True");
    }
}
