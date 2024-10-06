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

### Detected Test Smell

After using PMD on the Commons Collections project with the rule `JUnitUseExpected` (thanks to the command `pmd check -d <path to commons-collections> -R category/java/bestpractices.xml/JUnitUseExpected -f text`), we can find several places where exception handling in JUnit tests was done manually through try-catch blocks rather than using `@Test(expected = Exception.class)`. This makes the code less readable and understandable. 

You can find in the code/tp3-test-smells the full report. We chose to focus on one example observed in the `AbstractMapTest.java` file at line 1495.

Here is the message received by PMD : 

```
In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
```

Here is the associated code :

```java
try {
    computeIfAbsent(keys[0], k -> newValues[0]);
    fail("Expected IllegalArgumentException or UnsupportedOperationException on putIfAbsent (change)");
} catch (final IllegalArgumentException | UnsupportedOperationException ex) {
    // ignore
}
```

In fact, this test manually handles the expected exceptions `IllegalArgumentException` and `UnsupportedOperationException`, by using a try-catch block.

#### Possible Improvement

The solution could be to refactor the test case by using `@Test(expected = Exception.class)`. It simplifies it and makes it more readable because it directly informs us that an exception is expected. So this test case is also more maintainable with this modification. 

Here’s the improved version of the test case:

```java
@Test(expected = IllegalArgumentException.class)
public void testMapComputeIfAbsentWithIllegalArgument() {
    computeIfAbsent(keys[0], k -> newValues[0]);
}
```

But to go further, we saw in the previous exercise that JUnit 5 thanks to `assertThrows` is better compared to `@Test` proposed in JUnit 4. Let us use it instead. It is more flexible because we can now separate the two exceptions to better identify the exception if it occurs. It gives something like that :

``` java
@Test
public void testMapComputeIfAbsentWithExceptions() {
    assertThrows(IllegalArgumentException.class, () -> {
        computeIfAbsent(keys[0], k -> newValues[0]);
    });
    assertThrows(UnsupportedOperationException.class, () -> {
        computeIfAbsent(keys[0], k -> newValues[0]);
    });
}
```

We can also add that it reduces the chance of false positives because the test is now more robust (by clearly specifying which exceptions are expected) in the measure where we are reducing test smells.