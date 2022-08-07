package com.koderoom.tdd.suites;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("AllUnitTestsV1")
@SelectPackages("com.koderoom.tdd.handson")
public class AllUnitTestsV1 {
    @Test
    void test1() {
        Assertions.assertThat(true).isTrue();
    }
}