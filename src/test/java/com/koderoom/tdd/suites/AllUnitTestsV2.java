package com.koderoom.tdd.suites;


import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("AllUnitTestsV2")
@SelectPackages({"com.koderoom.tdd.controller", "com.koderoom.tdd.service", "com.koderoom.tdd.repository"})
public class AllUnitTestsV2 {
}
