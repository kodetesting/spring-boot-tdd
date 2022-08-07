package com.koderoom.tdd.suites;


import com.koderoom.tdd.handson.JunitBasicsHandsonTest;
import com.koderoom.tdd.handson.JunitBasicsHandsonV1Test;
import com.koderoom.tdd.handson.JunitBasicsHandsonV2Test;
import com.koderoom.tdd.handson.JunitBasicsLifeCycleTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Unit Test using Classes")
@SelectClasses({JunitBasicsHandsonTest.class, JunitBasicsHandsonV1Test.class, JunitBasicsHandsonV2Test.class, JunitBasicsLifeCycleTest.class})
public class AllUnitTests {
    @Test
    void test1() {
        Assertions.assertThat(true).isTrue();
    }
}
