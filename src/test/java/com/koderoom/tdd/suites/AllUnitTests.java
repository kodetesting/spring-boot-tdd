package com.koderoom.tdd.suites;


import com.koderoom.tdd.handson.JunitBasicsHandson;
import com.koderoom.tdd.handson.JunitBasicsHandsonV1;
import com.koderoom.tdd.handson.JunitBasicsHandsonV2;
import com.koderoom.tdd.handson.JunitBasicsLifeCycle;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({JunitBasicsHandson.class, JunitBasicsHandsonV1.class, JunitBasicsHandsonV2.class, JunitBasicsLifeCycle.class})
public class AllUnitTests {
}
