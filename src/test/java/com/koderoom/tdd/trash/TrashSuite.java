package com.koderoom.tdd.trash;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({HelloServiceTest.class, BookServiceTest.class})
public class TrashSuite {
}
