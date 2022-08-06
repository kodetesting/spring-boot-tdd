package com.koderoom.tdd.handson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @DisplayName("AssertJ with string")
    void test3() {
        Assertions.assertThat("The Lord of the Rings")
                .isNotNull()
                .isNotEmpty()
                .startsWith("The")
                .contains("Lord")
                .doesNotContain("java")
                .endsWith("Rings");
    }

    @Test
    @DisplayName("AssertJ with Number")
    void test4() {
        Assertions.assertThat(10)
                .isNotNull()
                .isNotZero()
                .isEven()
                .isLessThan(100)
                .isGreaterThan(1)
                .isCloseTo(12, Offset.offset(5))
                .isNotEqualTo(12)
                .isEqualTo(10);
    }

    @Test
    @DisplayName("AssertJ with list")
    void test5() {
        List<String> list = Arrays.asList("delhi", "calcutta", "chennai", "mumbai");
        Assertions.assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .hasSize(4)
                .contains("chennai", "mumbai")
                .doesNotContain("kochi")
                .containsSequence("calcutta", "chennai")
                .containsSubsequence("delhi", "chennai");
    }

    @Test
    @DisplayName("AssertJ with map")
    void test6() {
        Map<String, String> map = Map.of("a", "apple", "b", "ball");
        Assertions.assertThat(map)
                .isNotNull()
                .hasSize(2)
                .containsKey("a")
                .containsValue("apple")
                .containsEntry("a", "apple");
    }

    @Test
    @DisplayName("AssertJ Object")
    void test7() {
        Sample ref1 = new Sample(1, "rohit");

        Assertions.assertThat(ref1)
                .isNotNull()
                .hasFieldOrProperty("id")
                .hasFieldOrPropertyWithValue("id", 1)
        ;
    }


    @Test
    @DisplayName("AssertJ with list")
    void test8() {
        List<String> list = Arrays.asList("delhi", "calcutta", "chennai", "mumbai");
        Assertions.assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy((item) -> {
                    Assertions.assertThat(item)
                                .isNotNull()
                                .isNotEmpty()
                                .doesNotContainAnyWhitespaces();
                })
                .anySatisfy(item -> {
                    Assertions.assertThat(item)
                                .isEqualTo("mumbai");
                })
                .allMatch((item) -> item != null)
                .anyMatch((item) -> item.equalsIgnoreCase("chennai"));
    }


    @Test
    @DisplayName("AssertJ Object")
    void test9() {
        Sample ref1 = new Sample(1, "rohit");
        Sample ref2 = new Sample(1, "rohit");

        Assertions.assertThat(ref1)
                    .usingRecursiveComparison()
                    .isEqualTo(ref2)
        ;
        Assertions.assertThat(ref1).extracting("id").isEqualTo(1);


    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Sample {
    int id;
    String name;
}
