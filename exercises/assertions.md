# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### 1. `assertTrue(3 * .4 == 1.2)` failure

That is because of the floating-point precision issues. In fact, when performing floating-point arithmetic, some decimal numbers cannot be represented exactly, and that leads to small rounding errors. That is why, when we are executing this calculation in a code, we obtain : ``1.2000000000000002``.

This type of check should be done differently. We can consider that two floats are equal if their difference is negligible. To compare two floats with a tolerance error, we can use ``assertEquals(double expected, double actual, double delta)`` from JUnit, where delta is a small tolerance value that defines how close the two numbers need to be to be considered equal.

### 2. Difference between `assertEqual` and `assertSame`

- ``assertEqual`` : verify if two objects have the same value. For example,

``` java
String expected = "hello";
String actual = new String("hello");
assertEquals(expected, actual); // This passes because the content is the same
```

- ``assertSame`` : verify if two objects are the same according to their reference. For exemple,

``` java
String expected = "hello";
String actual = expected; // Both refer to the same object
assertSame(expected, actual); // This passes because they are the same reference

String another = new String("hello");
assertSame(expected, another); // This fails because they are different objects in memory
```

### 3. Other uses for `fail`

Modify a file without having the writing rights ? => maybe a try/catch is better
Too much memory used

- To indicate that a feature has not been implemented yet, for example :

``` java
@Test
public void testUnimplementedFeature() {
    fail("Feature not implemented yet");
}
```

- To indicate that we enter in a condition that should never occur, for example :

``` java
@Test
public void testUnexpectedCondition() {
    int result = someMethod();
    if (result < 0) {
        fail("Result should never be negative");
    }
}
```

### 4. `assertThrows` advantages compared to `@Test`

By the introduction of `assertThrows` in JUnit 5, we can notice :

- A Better control and readability: In fact, ```assertThrows``` controls where the exception is expected. This allows the test to continue afterward and even capture the exception object for further checks. With ```@Test```, the test stops once the exception is thrown, that limits further validation.

- A separation of test logic: it keeps the setup, exception-checking, and post-exception validation separated. That makes the tests cleaner and easier to maintain.

- Better IDE support: Some IDEs (like IntellIJ) offer improved code completion and error checking with ```assertThrows```, that makes simplier to write and maintain tests.

Sources : [IntelliJ IDEA Documentation](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/), [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/), [Stack Overflow Forum](https://stackoverflow.com/questions/53828270/testexpected-exception-class-or-assertions-assertthrows-or-assertthatt)
