# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

The PMD rules are :

- DetachedTestCase
- JUnit4SuitesShouldUseSuiteAnnotation
- JUnit4TestShouldUseAfterAnnotation
- JUnit4TestShouldUseBeforeAnnotation
- JUnit4TestShouldUseTestAnnotation
- JUnitAssertionsShouldIncludeMessage
- JUnitSpelling
- JUnitStaticSuite
- JUnitTestContainsTooManyAsserts
- JUnitTestsShouldIncludeAssert
- JUnitUseExpected
- UnnecessaryBooleanAssertion
- UseAssertEqualsInsteadOfAssertTrue
- UseAssertNullInsteadOfAssertTrue
- UseAssertSameInsteadOfAssertTrue
- UseAssertTrueInsteadOfAssertEquals

We chose the rule `JUnit4TestShouldUseBeforeAnnotation` and run it on the project Apache Commons Math.

```.
/run.sh pmd -d src/main/java -R category/java/bestpractices.xml/JUnit4TestShouldUseBeforeAnnotation -f text > sortie2.txt
```

We obtain : 

```
/src/main/java/org/apache/commons/math3/optimization/direct/BaseAbstractMultivariateVectorOptimizer.java:319:	JUnit4TestShouldUseBeforeAnnotation:	JUnit 4 tests that set up tests should use the @Before annotation, JUnit5 tests should use @BeforeEach or @BeforeAll
```

```
/src/main/java/org/apache/commons/math3/optimization/general/AbstractLeastSquaresOptimizer.java:503:	JUnit4TestShouldUseBeforeAnnotation:	JUnit 4 tests that set up tests should use the @Before annotation, JUnit5 tests should use @BeforeEach or @BeforeAll
```

Two tests smells were found to match the `JUnit4TestShouldUseBeforeAnnotation` rule. This comes from two functions called setUp(). Both of these files are not test files, so we should not consider these smells.
