package com.koderoom.tdd.handson;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Assert4J Handson")
public class Assert4JV1Test {

    @Test
    @DisplayName("Assertj Boolean")
    void test1() {
        Assertions.assertThat(true).isTrue();
        Assertions.assertThat(false).isFalse();
    }

    @Test
    @DisplayName("Assert Null Check")
    void test2() {
        String str = null;

        Assertions.assertThat(str).isNull();
        Assertions.assertThat("").isNullOrEmpty();
        Assertions.assertThat("mumbai").isNotNull();
    }

    @Test
    @DisplayName("Assert equals")
    void test3() {
        Assertions.assertThat(5).isEqualTo(5);
        Assertions.assertThat(5).isEqualTo(5).withFailMessage("Expected 5");

        Assertions.assertThat("The Lord of the Rings").isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");
    }
}
