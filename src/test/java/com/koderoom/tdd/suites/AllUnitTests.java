package com.koderoom.tdd.suites;


import com.koderoom.tdd.handson.JunitBasicsHandson;
import com.koderoom.tdd.handson.JunitBasicsHandsonV1;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({JunitBasicsHandson.class, JunitBasicsHandsonV1.class})
public class AllUnitTests {
}
