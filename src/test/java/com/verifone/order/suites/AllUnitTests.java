package com.verifone.order.suites;


import com.verifone.order.handson.JunitBasicsHandsonTest;
import com.verifone.order.handson.JunitBasicsHandsonV1Test;
import com.verifone.order.handson.JunitBasicsHandsonV2Test;
import com.verifone.order.handson.JunitBasicsLifeCycleTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Unit Test using Classes")
@SelectClasses({JunitBasicsHandsonTest.class, JunitBasicsHandsonV1Test.class, JunitBasicsHandsonV2Test.class, JunitBasicsLifeCycleTest.class})
public class AllUnitTests {
}
