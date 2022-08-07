package com.koderoom.tdd.suites;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Unit Test using Classes")
// @SelectClasses({JunitBasicsHandsonTest.class, JunitBasicsHandsonV1Test.class, JunitBasicsHandsonV2Test.class, JunitBasicsLifeCycleTest.class})
@SelectPackages("com.koderoom.tdd.handson")
class AllUnitTests {
    @Test
    void test1() {
        boolean actual = true;
        Assertions.assertThat(actual).isTrue();
    }
}
