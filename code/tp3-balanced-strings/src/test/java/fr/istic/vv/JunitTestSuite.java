package fr.istic.vv;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestNull.class, 
	TestNoSymbols.class, 
	StringUtilsTest.class
})

public class JunitTestSuite {   
}