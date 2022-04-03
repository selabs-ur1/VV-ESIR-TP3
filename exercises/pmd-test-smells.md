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

|PMD rule                                     | discusses in classes  |
|---------------------------------------------|-----------------------|
|DetachedTestCase                             |Maybe                  |
|JUnit4SuitesShouldUseSuiteAnnotation         |No                     |
|JUnit4TestShouldUseAfterAnnotation           |**Yes**                |
|JUnit4TestShouldUseBeforeAnnotation          |**Yes**                |
|JUnit4TestShouldUseTestAnnotation            |**Yes**                |
|JUnitAssertionsShouldIncludeMessage          |No                     |
|JUnitSpelling                                |**Yes**                |
|JUnitStaticSuite                             |No                     |
|JUnitTestContainsTooManyAsserts              |**Yes**                |
|JUnitTestsShouldIncludeAssert                |**Yes**                |
|JUnitUseExpected                             |No                     |
|UnnecessaryBooleanAssertion                  |No                     |
|UseAssertEqualsInsteadOfAssertTrue           |No                     |
|UseAssertNullInsteadOfAssertTrue             |No                     |
|UseAssertSameInsteadOfAssertTrue             |No                     |
|UseAssertTrueInsteadOfAssertEquals           |No                     |

1. UseTestAnnotation : We detect 125 errors on Apache Commons Math
```java
public void testConcatenateEmptyArguments() {
        final double[] x = new double[] {0, 1, 2};
        final double[] y = new double[] {3};
        final double[] z = new double[] {};
        final double[] u = new double[] {0, 1, 2, 3};
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, z, y), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, y, z), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(z, x, y), 0);
        Assert.assertEquals(0,  MathArrays.concatenate(z, z, z).length);
    }
```
As we can see this test does not use the @Test annotation, so it will not be executed.
To correct this bug we just need to add `@Test` in front of the method declaration.
